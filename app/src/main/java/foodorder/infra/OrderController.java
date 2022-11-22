package foodorder.infra;
import foodorder.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@RestController
// @RequestMapping(value="/orders")
@Transactional
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @PostMapping(value="/orders")
    public void createOrder(@RequestBody CreateOrderCommand ordercmd) {
        Order order = new Order();
        order.setItem(ordercmd.getItem());
        order.setQty(ordercmd.getQty());
        order.setPrice(ordercmd.getPrice());
        // 필요시 item의 부가 정보를 조회하여 order entity에 셋팅함.
        orderRepository.save()
    }
}
