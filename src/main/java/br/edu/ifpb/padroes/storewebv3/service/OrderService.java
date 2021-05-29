package br.edu.ifpb.padroes.storewebv3.service;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private Order order;
    private final Mediator paymentMediator;

    public OrderService(Mediator paymentMediator) {
        this.paymentMediator = paymentMediator;
    }

    public void processPayment() {
        paymentMediator.notify(this, EMediatorEvents.PROCESS_PAYMENT);
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
