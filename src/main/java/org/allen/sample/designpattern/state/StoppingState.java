package org.allen.sample.designpattern.state;

public class StoppingState extends LiftState {
    @Override
    public void open() {
        super.context.setLiftState(Context.openningState);
        super.context.getLiftState().open();
    }

    @Override
    public void close() {

    }

    @Override
    public void run() {
        super.context.setLiftState(Context.openningState);
        super.context.getLiftState().open();
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.openningState);
        super.context.getLiftState().open();
    }
}
