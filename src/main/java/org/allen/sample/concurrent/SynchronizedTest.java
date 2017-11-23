package org.allen.sample.concurrent;

/**
 * 非静态方法:
 * 给对象加锁(可以理解为给这个对象的内存上锁,注意 只是这块内存,其他同类对象都会有各自的内存锁),这时候
 * 在其他一个以上线程中执行该对象的这个同步方法(注意:是该对象)就会产生互斥
 * <p>
 * 静态方法:
 * 相当于在类上加锁(*.class 位于代码区,静态方法位于静态区域,这个类产生的对象公用这个静态方法,所以这块
 * 内存，N个对象来竞争), 这时候,只要是这个类产生的对象,在调用这个静态方法时都会产生互斥
 * <p>
 * synchronized关键字是不能继承的，也就是说，基类的方法synchronized f(){} 在继承类中并不自动是synchronized f(){}，而是变成了f(){}。
 * 继承类需要你显式的指定它的某个方法为synchronized方法。
 */
public class SynchronizedTest {

    public void methodOne() {
        System.out.println(Thread.currentThread().getName() + " say one");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " say one again");
    }

    public synchronized void methodTwo() {
        System.out.println(Thread.currentThread().getName() + " say two");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " say two again");
    }

    public synchronized void methodThree() {
        System.out.println(Thread.currentThread().getName() + " say three");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " say three again");
    }

    public static synchronized void methodFour() {
        System.out.println(Thread.currentThread().getName() + " say four");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " say four again");
    }


    public static void main(String[] args) {
//        noLock();
//        anotherNoLock();
        thirdNoLock();
//        objectLock();
//        anotherObjectLock();
//        classLock();
//        anotherClassLock();
    }

    /**
     *
     */
    public static void noLock() {
        SynchronizedTest object = new SynchronizedTest();
        new Thread(new ThreadA(object)).start();
        new Thread(new ThreadA(object)).start();
    }

    public static void anotherNoLock() {
        SynchronizedTest object = new SynchronizedTest();
        new Thread(new ThreadA(object)).start();
        new Thread(new ThreadB(object)).start();
    }

    public static void thirdNoLock() {
        SynchronizedTest object1 = new SynchronizedTest();
        SynchronizedTest object2 = new SynchronizedTest();
        new Thread(new ThreadB(object1)).start();
        new Thread(new ThreadB(object2)).start();
    }

    public static void objectLock() {
        SynchronizedTest object = new SynchronizedTest();
        new Thread(new ThreadB(object)).start();
        new Thread(new ThreadB(object)).start();
    }

    public static void anotherObjectLock() {
        SynchronizedTest object = new SynchronizedTest();
        new Thread(new ThreadB(object)).start();
        new Thread(new ThreadC(object)).start();
    }

    public static void classLock() {
        SynchronizedTest object = new SynchronizedTest();
        new Thread(new ThreadD(object)).start();
        new Thread(new ThreadD(object)).start();
    }

    public static void anotherClassLock() {
        SynchronizedTest object1 = new SynchronizedTest();
        SynchronizedTest object2 = new SynchronizedTest();
        new Thread(new ThreadD(object1)).start();
        new Thread(new ThreadD(object2)).start();
    }

    static class ThreadA implements Runnable {

        private SynchronizedTest synchronizedTestA;

        public ThreadA(SynchronizedTest synchronizedTest) {
            this.synchronizedTestA = synchronizedTest;
        }

        @Override
        public void run() {
            synchronizedTestA.methodOne();
        }
    }

    static class ThreadB implements Runnable {

        private SynchronizedTest synchronizedTestB;

        public ThreadB(SynchronizedTest synchronizedTest) {
            this.synchronizedTestB = synchronizedTest;
        }

        @Override
        public void run() {
            synchronizedTestB.methodTwo();
        }
    }

    static class ThreadC implements Runnable {

        private SynchronizedTest synchronizedTestC;

        public ThreadC(SynchronizedTest synchronizedTest) {
            this.synchronizedTestC = synchronizedTest;
        }

        @Override
        public void run() {
            synchronizedTestC.methodThree();
        }
    }

    static class ThreadD implements Runnable {

        private SynchronizedTest synchronizedTestD;

        public ThreadD(SynchronizedTest synchronizedTest) {
            this.synchronizedTestD = synchronizedTest;
        }

        @Override
        public void run() {
            synchronizedTestD.methodFour();
        }
    }
}
