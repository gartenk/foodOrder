package foodorder.domain;

import foodorder.domain.PayApprovaled;
import foodorder.domain.PayCanceled;
import foodorder.PayApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Payment_table")
@Data

public class Payment  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private Double price;
    
    
    
    
    
    private Boolean aprovaled;
    
    
    
    
    
    private Boolean canceled;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String receiver;

    @PrePersist
    public void onPrePersist(){


        PayApprovaled payApprovaled = new PayApprovaled(this);
        payApprovaled.publishAfterCommit();



        PayCanceled payCanceled = new PayCanceled(this);
        payCanceled.publishAfterCommit();

    }

    public static PaymentRepository repository(){
        PaymentRepository paymentRepository = PayApplication.applicationContext.getBean(PaymentRepository.class);
        return paymentRepository;
    }




    public static void cancelPay(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);


         });
        */

        
    }

    // 주문을 저장한다.
    public static void createPay(Payment payment) {
        repository().createPay(payment)
    }


}
