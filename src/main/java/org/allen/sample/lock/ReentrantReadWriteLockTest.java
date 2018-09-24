package org.allen.sample.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final ReentrantReadWriteLockTest test = new ReentrantReadWriteLockTest();

        new Thread("A") {
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();

        new Thread("B") {
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();
    }

    public void get(Thread thread) {
        rwl.readLock().lock();
        try {
            System.out.println("线程" + thread.getName() + "开始读操作...");
            Thread.sleep(100);
            System.out.println("线程" + thread.getName() + "读操作完毕...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwl.readLock().unlock();
        }
    }

}
