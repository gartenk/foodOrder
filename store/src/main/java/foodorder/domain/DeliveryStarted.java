package foodorder.domain;

import foodorder.domain.*;
import foodorder.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String item;
    private Integer qty;
    private String address;
    private String receiver;

    public DeliveryStarted(Order aggregate){
        super(aggregate);
    }
    public DeliveryStarted(){
        super();
    }
}
