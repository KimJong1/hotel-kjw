package hotelkjw.domain;

import hotelkjw.RoomApplication;
import hotelkjw.domain.Outofstock;
import hotelkjw.domain.Roomdecresed;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Room_table")
@Data
//<<< DDD / Aggregate Root
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long roomId;

    private Integer stock;

    private Integer reservationId;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Roomdecresed roomdecresed = new Roomdecresed(this);
        roomdecresed.publishAfterCommit();

        Outofstock outofstock = new Outofstock(this);
        outofstock.publishAfterCommit();
    }

    public static RoomRepository repository() {
        RoomRepository roomRepository = RoomApplication.applicationContext.getBean(
            RoomRepository.class
        );
        return roomRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreseRoom(Reservationcompleted reservationcompleted) {

        repository().findById(Long.valueOf(reservationcompleted.getId())).ifPresent(room->{

            if(room.getStock() - reservationcompleted.getQty() >= 0){
                room.setStock(room.getStock() - reservationcompleted.getQty());
                repository().save(room);
            }
            else{
                Outofstock outofstock = new Outofstock(room);
                outofstock.publishAfterCommit();
            }
            
        });
        
        //implement business logic here:

        /** Example 1:  new item 
        Room room = new Room();
        repository().save(room);

        Roomdecresed roomdecresed = new Roomdecresed(room);
        roomdecresed.publishAfterCommit();
        Outofstock outofstock = new Outofstock(room);
        outofstock.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(reservationcompleted.get???()).ifPresent(room->{
            
            room // do something
            repository().save(room);

            Roomdecresed roomdecresed = new Roomdecresed(room);
            roomdecresed.publishAfterCommit();
            Outofstock outofstock = new Outofstock(room);
            outofstock.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
