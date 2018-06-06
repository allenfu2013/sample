package org.allen.sample.designpattern.state;

public class OpenningState extends LiftState{


    @Override
    public void open() {
        System.out.println("电梯门开启...");
    }

    @Override
    public void close() {
        //状态修改
        super.context.setLiftState(Context.closingState);
        //动作委托为CloseState来执行
        super.context.getLiftState().close();
    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }
}
