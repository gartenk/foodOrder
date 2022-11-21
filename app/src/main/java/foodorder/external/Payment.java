package foodorder.external;

import lombok.Data;
import java.util.Date;
@Data
public class Payment {

    private Long id;
    private String orderId;
    private Double price;
    private Boolean aprovaled;
    private Boolean canceled;
    private String address;
    private String receiver;
}


