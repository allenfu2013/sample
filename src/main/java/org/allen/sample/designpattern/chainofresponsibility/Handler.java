package org.allen.sample.designpattern.chainofresponsibility;

/**
 * 一个纯的责任链模式要求一个具体的处理者对象只能在两个行为中选择一个：一是承担责任，而是把责任推给下家。
 * 不允许出现某一个具体处理者对象在承担了一部分责任后又 把责任向下传的情况。
 * 在一个纯的责任链模式里面，一个请求必须被某一个处理者对象所接收；
 * 在一个不纯的责任链模式里面，一个请求可以最终不被任何接收端对象所接收。
 */
public abstract class Handler {

    protected Handler successor;

    public abstract void handleRequest(Request request);

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
