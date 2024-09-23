package hotelkjw.domain;

import hotelkjw.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class Outofstock extends AbstractEvent {

    private Long id;
    private String userId;
    private Integer stock;
    private Integer reservationId;
    private String status;
    private Long roomId;
}
