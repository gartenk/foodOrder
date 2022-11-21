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
    @Autowired 주문Repository 주문Repository;
    @Autowired OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='배달시작됨'")
    public void whenever배달시작됨_주문상태변경(@Payload 배달시작됨 배달시작됨){

        배달시작됨 event = 배달시작됨;
        System.out.println("\n\n##### listener 주문상태변경 : " + 배달시작됨 + "\n\n");


        

        // Sample Logic //

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryStarted'")
    public void wheneverDeliveryStarted_ChangeOrderState(@Payload DeliveryStarted deliveryStarted){

        DeliveryStarted event = deliveryStarted;
        System.out.println("\n\n##### listener ChangeOrderState : " + deliveryStarted + "\n\n");


        

        // Sample Logic //
        Order.changeOrderState(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryEnded'")
    public void wheneverDeliveryEnded_ChangeOrderState(@Payload DeliveryEnded deliveryEnded){

        DeliveryEnded event = deliveryEnded;
        System.out.println("\n\n##### listener ChangeOrderState : " + deliveryEnded + "\n\n");


        

        // Sample Logic //
        Order.changeOrderState(event);
        

        

    }

}


