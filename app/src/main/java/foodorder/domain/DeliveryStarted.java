package foodorder.domain;

import foodorder.domain.*;
import foodorder.infra.AbstractEvent;
import lombok.*;
import java.util.*;

@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String item;
    private Integer qty;
    private String address;
    private String receiver;
}


