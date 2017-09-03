package org.allen.sample.designpattern.chainofresponsibility;

public class ConcreteHandler2 extends Handler {

    @Override
    public void handleRequest(Request request) {
        if (request.getFee() < 1000) {
            //自己处理
            System.out.println("ConcreteHandler2 processed");
        } else {
            if (getSuccessor() != null) {
                getSuccessor().handleRequest(request);
            }
        }
    }
}
