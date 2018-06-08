package org.allen.sample.designpattern.strategy;

public class ConcreteStrategyA implements Strategy {

    @Override
    public void strategyInterface() {
        System.out.println("This is a concrete strategy A");
    }
}
