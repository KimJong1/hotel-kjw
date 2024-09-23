package hotelkjw.domain;

import hotelkjw.domain.*;
import hotelkjw.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Outofstock extends AbstractEvent {

    private Long id;
    private String userId;
    private Integer stock;
    private Integer reservationId;
    private String status;
    private Long roomId;
}
