package br.edu.ifpb.padroes.storewebv3.service;

import br.edu.ifpb.padroes.storewebv3.PromotionVisitor;
import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.domain.OrderItem;
import br.edu.ifpb.padroes.storewebv3.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

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
        PromotionVisitor promotionVisitor = new PromotionVisitor();
        List<OrderItem> orderItems = order.getItems();

        for(OrderItem single: orderItems) {
            single.getProduct().accept(promotionVisitor);
        }
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
