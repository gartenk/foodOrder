package foodorder.domain;

import foodorder.domain.*;
import foodorder.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Ordered extends AbstractEvent {

    private Long id;
    private String item;
    private Integer qty;
    private Double price;
}


