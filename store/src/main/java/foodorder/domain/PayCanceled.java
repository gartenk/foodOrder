package foodorder.domain;

import foodorder.domain.*;
import foodorder.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class PayCanceled extends AbstractEvent {

    private Long id;
    private String orderId;
    private Double price;
    private Boolean aprovaled;
    private Boolean canceled;
}


