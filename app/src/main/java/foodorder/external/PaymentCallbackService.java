package foodorder.external;

import org.springframework.stereotype.Service;

@Service
public class PaymentCallbackService implements PaymentService {
    public void createPay(Payment payment){
        // 임시 payment 정보를 생성하고.. 추후 처리함.
        repository.save(payment);
        // 성공 처리
    }
}