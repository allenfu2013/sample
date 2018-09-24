package org.allen.sample.jmm;

public class VolatileTest  {

    private volatile Integer count = 0;

    public void addCount() {
        count = count + 1;
    }

    public Integer getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest test = new VolatileTest();
        Thread thread1 = new MyThread(test);
        Thread thread2 = new MyThread(test);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(test.getCount());
    }

    static class MyThread extends Thread {
        private VolatileTest test;

        public MyThread(VolatileTest test) {
            this.test = test;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                test.addCount();
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
