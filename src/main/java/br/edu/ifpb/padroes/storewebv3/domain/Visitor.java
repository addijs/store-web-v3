package br.edu.ifpb.padroes.storewebv3.domain;

public interface Visitor {

    void visitEletronic(Eletronic eletronic);
    void visitBook(Book book);
}
