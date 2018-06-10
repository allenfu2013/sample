package org.allen.sample.designpattern.template;

public class ConcreteClass1 extends AbstractClass {

    @Override
    protected void doAnything() {
        System.out.println("concrete1 do anything");
    }

    @Override
    protected void doSomething() {
        System.out.println("concrete1 do something");
    }
}