package org.allen.sample.designpattern.factory.simple;

public class Client {

    public static void main(String[] args) {
        //获取 Circle 的对象，并调用它的 draw 方法
        Shape shape1 = ShapeFactory.getShape(ShapeFactory.SHAPE_CIRCLE);

        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape2 = ShapeFactory.getShape(ShapeFactory.SHAPE_RECT);

        //调用 Rectangle 的 draw 方法
        shape2.draw();

        //获取 Square 的对象，并调用它的 draw 方法
        Shape shape3 = ShapeFactory.getShape(ShapeFactory.SHAPE_SQUARE);

        //调用 Square 的 draw 方法
        shape3.draw();
    }
}
