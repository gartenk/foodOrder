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

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PayApprovaled'")
    public void wheneverPayApprovaled_ReceiveOrder(@Payload PayApprovaled payApprovaled){

        PayApprovaled event = payApprovaled;
        System.out.println("\n\n##### listener ReceiveOrder : " + payApprovaled + "\n\n");        

        // Sample Logic //
        Order.receiveOrder(event);   
    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PayCanceled'")
    public void wheneverPayCanceled_CancelOrder(@Payload PayCanceled payCanceled){

        PayCanceled event = payCanceled;
        System.out.println("\n\n##### listener CancelOrder : " + payCanceled + "\n\n");
        // Sample Logic //
        Order.cancelOrder(event);
    }

}


