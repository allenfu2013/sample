package org.allen.utility.designpattern.chainofresponsibility;

/**
 * Created by allen on 17/3/6.
 */
public class Client {

    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();

        handler1.setSuccessor(handler2);
        handler2.setSuccessor(handler3);

        Request request = new Request();
        request.setFee(700);
        handler1.handleRequest(request);

        request.setFee(1200);
        handler1.handleRequest(request);
    }
}
