package foodorder.domain;

import foodorder.domain.*;
import foodorder.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PayCanceled extends AbstractEvent {

    private Long id;
    private String orderId;
    private Double price;
    private Boolean aprovaled;
    private Boolean canceled;

    public PayCanceled(Payment aggregate){
        super(aggregate);
    }
    public PayCanceled(){
        super();
    }
}
