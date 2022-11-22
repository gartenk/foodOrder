package foodorder.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Data
public class CreateOrderCommand {    
    private String item;
    private Integer qty;
    private Double price;
}
