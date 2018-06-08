package org.allen.sample.designpattern.builder;

public interface Builder {

    void buildWheel();

    void buildSkeleton();

    void buildEngine();

    Product buildProduct();
}
