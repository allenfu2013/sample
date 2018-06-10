package org.allen.sample.designpattern.singleton;

/**
 * 登记式/静态内部类
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 这种方式能达到双检锁方式一样的功效，但实现更简单。
 * 对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
 * 这种方式同样利用了classloader机制来保证初始化 instance 时只有一个线程。
 * 这种方式是Singleton类被装载了，instance不一定被初始化。
 * 因为 SingletonHolder 类没有被主动使用，只有通过显式调用getInstance方法时，才会显式装载SingletonHolder类，从而实例化instance。
 */
public class Singleton5 {

    private static class SingletonHolder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    private Singleton5() {
    }

    public static final Singleton5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
