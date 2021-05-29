package br.edu.ifpb.padroes.storewebv3.rest;

import br.edu.ifpb.padroes.storewebv3.config.StoreConfigurationProperties;
import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.payment.StripeApi;
import br.edu.ifpb.padroes.storewebv3.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderResource {

    private final OrderService orderService;

    public OrderResource() {
        this.orderService = new OrderService(new StripeApi(new StoreConfigurationProperties()));
    }

    @PostMapping("/")
    public ResponseEntity<Void> createProduct(@RequestBody Order order) {
        orderService.setOrder(order);
        orderService.processPayment();
        return ResponseEntity.ok().build();
    }
}
