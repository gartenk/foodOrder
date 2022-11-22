package foodorder.domain;

import foodorder.domain.주문됨;
import foodorder.domain.Ordered;
import foodorder.domain.주문취소됨;
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
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String receiver;
    
    
    
    
    
    private String moblieNo;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        foodorder.external.결제이력 결제이력 = new foodorder.external.결제이력();
        // mappings goes here
        Application.applicationContext.getBean(foodorder.external.결제이력Service.class)
            .결제(결제이력);


        주문됨 주문됨 = new 주문됨(this);
        주문됨.publishAfterCommit();


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


        주문취소됨 주문취소됨 = new 주문취소됨(this);
        주문취소됨.publishAfterCommit();



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
