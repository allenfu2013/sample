package org.allen.utility.designpattern.chainofresponsibility;

public class ConcreteHandler3 extends Handler {

    @Override
    public void handleRequest(Request request) {
        if (request.getFee() >= 1000) {
            //自己处理
            System.out.println("ConcreteHandler3 processed");
        } else {
            if (getSuccessor() != null) {
                getSuccessor().handleRequest(request);
            }
        }
    }
}
