package hotelkjw.domain;

import hotelkjw.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RoomReserved extends AbstractEvent {

    private Long id;
    private String userId;
    private String status;
    private Integer qty;
    private Integer reservationId;
    private Long roomId;
}
