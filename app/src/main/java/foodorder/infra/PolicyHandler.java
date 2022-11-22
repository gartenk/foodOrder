package foodorder.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import foodorder.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import foodorder.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_ChangeOrderState(@Payload DeliveryStarted deliveryStarted){

        // 배송 시작시 메시지를 받아서 주문 상태를 변경함.
        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener ChangeOrderState : " + deliveryStarted + "\n\n");        

        Order.changeOrderState(event);
    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryEnded'")
    public void wheneverDeliveryEnded_ChangeOrderState(@Payload DeliveryEnded deliveryEnded){

        DeliveryEnded event = deliveryEnded;
        System.out.println("\n\n##### listener ChangeOrderState : " + deliveryEnded + "\n\n");


        

        // Sample Logic //
        Order.changeOrderState(event);
        

        

    }
    
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCanceled'")
    public void wheneverDeliveryEnded_ChangeOrderState(@Payload OrderCanceled orderCanceled){
        OrderCanceled event = orderCanceled;
        Order.changeOrderState(event);   
    }

}


