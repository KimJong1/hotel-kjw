package hotelkjw.domain;

import hotelkjw.domain.*;
import hotelkjw.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Roomdecresed extends AbstractEvent {

    private Long id;
    private Integer stock;
    private Integer reservationId;
    private String status;
    private Long roomId;

    public Roomdecresed(Room aggregate) {
        super(aggregate);
    }

    public Roomdecresed() {
        super();
    }
}
//>>> DDD / Domain Event
