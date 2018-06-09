package org.allen.sample.designpattern.bridge.example;

public abstract class Shape {

    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
