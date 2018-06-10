package org.allen.sample.designpattern.template;

public class ConcreteClass2 extends AbstractClass {

    @Override
    protected void doAnything() {
        System.out.println("concrete2 do anything");
    }

    @Override
    protected void doSomething() {
        System.out.println("concrete2 do something");
    }
}