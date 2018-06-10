package org.allen.sample.designpattern.template;

public abstract class AbstractClass {

    protected abstract void doAnything();

    protected abstract void doSomething();

    public final void templateMethod() {
        /*
         * 调用基本方法，完成相关的逻辑
         */
        this.doAnything();
        this.doSomething();
    }
}
