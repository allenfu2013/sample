package org.allen.sample.designpattern.factory.abstractfactory;

import org.allen.sample.designpattern.factory.simple.Circle;
import org.allen.sample.designpattern.factory.simple.Rectangle;
import org.allen.sample.designpattern.factory.simple.Shape;
import org.allen.sample.designpattern.factory.simple.Square;

public class ShapeFactory1 extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}