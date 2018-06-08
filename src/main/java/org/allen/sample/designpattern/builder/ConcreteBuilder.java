package org.allen.sample.designpattern.builder;

public class ConcreteBuilder implements Builder {

    Product product;

    public ConcreteBuilder() {
        product = new Product();
    }


    @Override
    public void buildWheel() {
        product.setWheel("Wheel");
    }

    @Override
    public void buildSkeleton() {
        product.setSkeleton("Skeleton");
    }

    @Override
    public void buildEngine() {
        product.setEngine("Engine");
    }

    @Override
    public Product buildProduct() {
        return product;
    }
}
