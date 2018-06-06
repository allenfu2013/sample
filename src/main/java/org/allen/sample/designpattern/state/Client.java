package org.allen.sample.designpattern.state;

/**
 * 定义：当一个对象内在状态改变时允许其改变行为，这个对象看起来像改变了其类。
 * 场景：1.行为随状态的改变而改变。2.如果需要使用大量的条件、分支判断。
 */
public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
