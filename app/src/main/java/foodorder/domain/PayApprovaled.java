package foodorder.domain;

import foodorder.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class PayApprovaled extends AbstractEvent {

    private Long id;
    private String orderId;
    private Double price;
    private Boolean aprovaled;
    private Boolean canceled;
    private String address;
    private String receiver;
    private String mobileNo;
}
