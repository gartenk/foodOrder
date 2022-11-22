package foodorder.infra;

import foodorder.domain.*;
import foodorder.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MenuViewHandler {


    @Autowired
    private MenuRepository menuRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {
            if (!ordered.validate()) return;
            // view 객체 생성
            Menu menu = new Menu();
            // view 객체에 이벤트의 Value 를 set 함
            menu.setId(ordered.getId());
            menu.setItem(ordered.getItem());
            // view 레파지 토리에 save
            menuRepository.save(menu);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_CREATE_1 (@Payload DeliveryStarted deliveryStarted) {
        try {
            if (!deliveryStarted.validate()) return;
            // view 객체 생성
            Menu menu = new Menu();
            // view 객체에 이벤트의 Value 를 set 함
            menu.setItem(deliveryStarted.getItem());
            // 필요시 item 상세 정보를 조회하여 set
            // view 레파지 토리에 save
            menuRepository.save(menu);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_CREATE_2 (@Payload OrderCanceled orderCanceled) {
        try {
            if (!orderCanceled.validate()) return;
            // view 객체 생성
            Menu menu = new Menu();
            // view 객체에 이벤트의 Value 를 set 함
            menu.setItem(orderCanceled.getItem());
            // 필요시 item 상세 정보를 조회하여 set
            // view 레파지 토리에 save
            menuRepository.save(menu);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

