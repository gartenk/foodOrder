package foodorder.domain;

import foodorder.domain.*;
import foodorder.infra.AbstractEvent;
import lombok.*;
import java.util.*;

@Data
@ToString
public class DeliveryEnded extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Integer deliveryState;
}


