package org.allen.sample.designpattern.command;

/**
 * 命令模式：将一个请求封装为一个对象，从而使我们可用不同的请求对客户进行参数化；对请求排队或者记录请求日志，以及支持可撤销的操作。
 * 适应性：
 * 1.系统需要将请求调用者和请求接收者解耦，使得调用者和接收者不直接交互。
 * 2.系统需要在不同的时间指定请求、将请求排队和执行请求。
 * 3.系统需要支持命令的撤销(Undo)操作和恢复(Redo)操作。
 * 4.系统需要将一组操作组合在一起，即支持宏命令。
 */
public class Client {

    public static void main(String[] args){
        Invoker invoker = new Invoker();
        Receiver receiver = new ConcreteReceiver1();

        Command command = new ConcreteCommand1(receiver);
        invoker.setCommand(command);
        invoker.action();
    }
}
