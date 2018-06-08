package org.allen.sample.designpattern.strategy;

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInteface() {
        strategy.strategyInterface();
    }
}
