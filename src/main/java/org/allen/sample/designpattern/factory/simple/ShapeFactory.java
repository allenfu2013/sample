package org.allen.sample.designpattern.factory.simple;

public class ShapeFactory {

    public static final int SHAPE_CIRCLE = 1;
    public static final int SHAPE_RECT = 2;
    public static final int SHAPE_SQUARE = 3;

    public static Shape getShape(int shapeType){

        switch (shapeType) {
            case SHAPE_CIRCLE:
                return new Circle();
            case SHAPE_RECT:
                return new Rectangle();
            case SHAPE_SQUARE:
            default:
                return new Circle();
        }


    }
}
