package br.edu.ifpb.padroes.storewebv3.service;

public interface Mediator {
    void notify(OrderService service, EMediatorEvents event);
}
