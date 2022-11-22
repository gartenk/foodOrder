package foodorder.domain;

import foodorder.domain.결제승인됨;
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
    
    
    
    
    
    private String mobileNo;

    @PrePersist
    public void onPrePersist(){


        결제승인됨 결제승인됨 = new 결제승인됨(this);
        결제승인됨.publishAfterCommit();



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


}
