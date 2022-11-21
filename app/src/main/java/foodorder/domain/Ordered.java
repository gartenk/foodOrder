package foodorder.domain;

import foodorder.domain.*;
import foodorder.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Ordered extends AbstractEvent {

    private Long id;
    private String item;
    private Integer qty;
    private Double price;

    public Ordered(Order aggregate) {
        super(aggregate);
    }

    public Ordered() {
        super();
    }
}
