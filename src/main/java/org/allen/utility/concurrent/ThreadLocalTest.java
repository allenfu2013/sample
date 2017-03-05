package org.allen.utility.concurrent;

/**
 * ThreadLocal 空间换时间
 * synchronized 时间换空间
 * ThreadLocalTest可以理解为是一个service，其中有个全局变量。当多线程并发时，对全局变量的操作会有线程安全问题。
 */
public class ThreadLocalTest {

    private ThreadLocal<Integer> counter = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public int getNextNum() {
        counter.set(counter.get() + 1);
        return counter.get();
    }

    public static void main(String[] args) {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        TestClient t1 = new TestClient(threadLocalTest);
        TestClient t2 = new TestClient(threadLocalTest);

        t1.start();
        t2.start();
    }

    private static class TestClient extends Thread {

        private ThreadLocalTest threadLocalTest;

        public TestClient(ThreadLocalTest threadLocalTest) {
            this.threadLocalTest = threadLocalTest;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> ["
                        + threadLocalTest.getNextNum() + "]");
            }
        }
    }
}
