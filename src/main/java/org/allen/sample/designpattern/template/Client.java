package org.allen.sample.designpattern.template;

public class Client {

    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass1();
        abstractClass.templateMethod();

        abstractClass = new ConcreteClass2();
        abstractClass.templateMethod();
    }
}
