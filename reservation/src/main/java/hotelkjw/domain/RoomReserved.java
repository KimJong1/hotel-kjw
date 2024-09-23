package hotelkjw.domain;

import hotelkjw.domain.*;
import hotelkjw.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class RoomReserved extends AbstractEvent {

    private Long id;
    private String userId;
    private String status;
    private Integer qty;
    private Integer reservationId;
    private Long roomId;

    public RoomReserved(Reservation aggregate) {
        super(aggregate);
    }

    public RoomReserved() {
        super();
    }
}
//>>> DDD / Domain Event
