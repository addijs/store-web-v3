package br.edu.ifpb.padroes.storewebv3.domain;

public class Eletronic extends Product {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitEletronic(this);
    }

}
