package br.edu.ifpb.padroes.storewebv3.domain;

public class Book extends Product {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitBook(this);
    }
}
