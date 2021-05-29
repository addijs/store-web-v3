package br.edu.ifpb.padroes.storewebv3.service;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends MediatedService {
    private Order order;

    public OrderService(Mediator paymentMediator) {
        super(paymentMediator);
    }

    public void processPayment() {
        super.mediator.notify(this, EMediatorEvents.PROCESS_PAYMENT);
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
