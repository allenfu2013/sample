package org.allen.sample.designpattern.chainofresponsibility;

public class ConcreteHandler1 extends Handler {

    @Override
    public void handleRequest(Request request) {
        if (request.getFee() < 500) {
            //自己处理
            System.out.println("ConcreteHandler1 processed");
        } else {
            if (getSuccessor() != null) {
                getSuccessor().handleRequest(request);
            }
        }
    }
}
