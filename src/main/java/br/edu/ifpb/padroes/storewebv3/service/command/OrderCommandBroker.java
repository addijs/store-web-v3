package br.edu.ifpb.padroes.storewebv3.service.command;

import java.util.Stack;

public class OrderCommandBroker {
    private Stack<Command> orderBroker = new Stack<>();

    public void push(Command c) {
        orderBroker.push(c);
    }

    public Command pop() {
        return orderBroker.pop();
    }

    public void executeAll() {
        for (Command command: orderBroker) {
            command.execute();
        }
    }

    public boolean isEmpty() { return orderBroker.isEmpty(); }
}
