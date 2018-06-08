package org.allen.sample.designpattern.builder;

public class Director {

    public Product buildProduct(Builder builder) {
        builder.buildWheel();
        builder.buildSkeleton();
        builder.buildEngine();
        return builder.buildProduct();
    }
}
