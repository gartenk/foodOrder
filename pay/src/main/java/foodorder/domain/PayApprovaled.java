package foodorder.domain;

import foodorder.domain.*;
import foodorder.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PayApprovaled extends AbstractEvent {

    private Long id;
    private String orderId;
    private Double price;
    private Boolean aprovaled;
    private Boolean canceled;
    private String address;
    private String receiver;

    public PayApprovaled(Payment aggregate){
        super(aggregate);
    }
    public PayApprovaled(){
        super();
    }
}
