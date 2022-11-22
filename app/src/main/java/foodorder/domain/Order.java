package foodorder.domain;

import foodorder.domain.Ordered;
import foodorder.domain.OrderCanceled;
import foodorder.AppApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String item;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private Double price;
    
    
    
    
    
    private Integer orderState;

    @PostPersist
    public void onPostPersist(){
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        foodorder.external.Payment payment = new foodorder.external.Payment();
        // mappings goes here
        AppApplication.applicationContext.getBean(foodorder.external.PaymentService.class)
            .createPay(payment);


        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){
        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();
    }
    @PreRemove
    public void onPreRemove(){
    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = AppApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void changeOrderState(DeliveryStarted deliveryStarted){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void changeOrderState(DeliveryEnded deliveryEnded){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryEnded.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }


}
