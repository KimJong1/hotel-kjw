package hotelkjw.domain;

import hotelkjw.domain.*;
import hotelkjw.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class RoomReserved extends AbstractEvent {

    private Long id;
    private String userId;
    private String status;
    private Integer qty;
    private Integer reservationId;
    private Long roomId;
}
