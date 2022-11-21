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
public class ViewOrderViewHandler {


    @Autowired
    private ViewOrderRepository viewOrderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayApprovaled_then_CREATE_1 (@Payload PayApprovaled payApprovaled) {
        try {

            if (!payApprovaled.validate()) return;

            // view 객체 생성
            ViewOrder viewOrder = new ViewOrder();
            // view 객체에 이벤트의 Value 를 set 함
            viewOrder.set(payApprovaled.get());
            // view 레파지 토리에 save
            viewOrderRepository.save(viewOrder);

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}

