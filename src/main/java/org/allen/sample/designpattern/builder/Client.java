package org.allen.sample.designpattern.builder;

/**
 * 建造者模式：是将一个复杂的对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * Builder：给出一个抽象接口或抽象类，以规范产品的建造。这个接口规定要实现复杂对象的哪些部分的创建，并不涉及具体的对象部件的创建，一般由子类具体实现。
 * ConcreteBuilder：Builder接口的实现类，并返回组建好对象实例。
 * Director：调用具体建造者来创建复杂对象的各个部分，在指导者中不涉及具体产品的信息，只负责保证对象各部分完整创建或按某种顺序创建。
 * 在现实开发中，往往省去Director的角色，而直接使用一个Buider实例来进行对象的组装。
 * Product：要创建的复杂对象，产品类。
 * 场景:
 * 1.当产品有复杂的内部构造时（参数很多）。
 * 2.需要生产的产品的属性相互依赖，这些属性的赋值顺序比较重要时（因为在调用ConcreteBuilder的赋值方法时是有先后顺序的）。
 */
public class Client {

    public static void main(String[] args) {
        Director director = new Director();
        Product product = director.buildProduct(new ConcreteBuilder());
        System.out.println(product.getEngine());
        System.out.println(product.getSkeleton());
        System.out.println(product.getWheel());
    }
}
