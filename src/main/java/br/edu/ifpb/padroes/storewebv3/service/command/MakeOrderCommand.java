package br.edu.ifpb.padroes.storewebv3.service.command;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.service.OrderFacade;

public class MakeOrderCommand extends Command{
    private OrderFacade orderFacade;
    private Order order;

    public MakeOrderCommand(OrderFacade orderFacade, Order order){
        this.orderFacade = orderFacade;
        this.order = order;
    }

    @Override
    public boolean execute() {
        this.orderFacade.createOrder(this.order);
        return true;
    }
}
