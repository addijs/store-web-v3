package br.edu.ifpb.padroes.storewebv3.service;

public abstract class MediatedService {
    protected final Mediator mediator;

    public MediatedService(Mediator mediator) {
        this.mediator = mediator;
    }
}
