package hotelkjw.domain;

import hotelkjw.domain.*;
import hotelkjw.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Outofstock extends AbstractEvent {

    private Long id;
    private String userId;
    private Integer stock;
    private Integer reservationId;
    private String status;
    private Long roomId;

    public Outofstock(Room aggregate) {
        super(aggregate);
    }

    public Outofstock() {
        super();
    }
}
//>>> DDD / Domain Event
