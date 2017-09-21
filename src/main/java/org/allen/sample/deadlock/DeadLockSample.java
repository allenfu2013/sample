package org.allen.sample.deadlock;


/**
 * 事例说明:
 * 2个线程竞争2个资源,第一个线程先获取aObj,后获取bObj,第二个线程则相反。
 */
public class DeadLockSample {

    static Object aObj = new Object();
    static Object bObj = new Object();


    public static void main(String[] args) {
        new Thread(new ThreadOne()).start();
        new Thread(new ThreadTwo()).start();
    }

    static class ThreadOne implements Runnable {

        @Override
        public void run() {
            synchronized (aObj) {
                System.out.println("ThreadOne got aObj");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (bObj) {
                    System.out.println("ThreadOne got bObj");
                }
            }
        }
    }

    static class ThreadTwo implements Runnable {

        @Override
        public void run() {
            synchronized (bObj) {
                System.out.println("ThreadTwo got bObj");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (aObj) {
                    System.out.println("ThreadTwo got aObj");
                }
            }
        }
    }

}
