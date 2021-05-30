package br.edu.ifpb.padroes.storewebv3.rest;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.service.OrderFacade;
import br.edu.ifpb.padroes.storewebv3.service.command.MakeOrderCommand;
import br.edu.ifpb.padroes.storewebv3.service.command.OrderCommandBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderResource {

    private final OrderFacade orderFacade;
    private final OrderCommandBroker orderCommandBroker;

    public OrderResource() {
        orderFacade = new OrderFacade();
        orderCommandBroker = new OrderCommandBroker();
    }

    @PostMapping("/")
    public ResponseEntity<Void> createOrder(@RequestBody Order order) {
        orderCommandBroker.push(new MakeOrderCommand(orderFacade, order));
        orderCommandBroker.executeAll();
        return ResponseEntity.ok().build();
    }
}
