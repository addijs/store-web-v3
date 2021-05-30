package br.edu.ifpb.padroes.storewebv3.rest;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.service.OrderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderResource {

    private final OrderFacade orderFacade;

    public OrderResource() {
        orderFacade = new OrderFacade();
    }

    @PostMapping("/")
    public ResponseEntity<Void> createProduct(@RequestBody Order order) {
        orderFacade.createOrder(order);
        return ResponseEntity.ok().build();
    }
}
