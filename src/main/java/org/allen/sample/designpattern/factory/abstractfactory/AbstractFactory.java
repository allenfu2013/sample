package org.allen.sample.designpattern.factory.abstractfactory;

import org.allen.sample.designpattern.factory.simple.Shape;

public abstract class AbstractFactory {

    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
