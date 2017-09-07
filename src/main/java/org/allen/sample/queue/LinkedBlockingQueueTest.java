package org.allen.sample.queue;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * put当队列满时阻塞,take当队列空时阻塞;
 * offer当队列满时不阻塞,返回boolean表示是否插入成功, poll当队列空时不会阻塞,返回null。
 */
public class LinkedBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);
        new Thread(new PutThread(queue)).start();
        new Thread(new TakeThread(queue)).start();
    }

    static class PutThread implements Runnable {
        LinkedBlockingQueue<Integer> queue = null;

        public PutThread(LinkedBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("ready to put");
                    int num = new Random().nextInt(100);
                    queue.put(num);
//                    boolean flag = queue.offer(num);
                    System.out.println("put num: " + num);
//                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class TakeThread implements Runnable {

        LinkedBlockingQueue<Integer> queue = null;

        public TakeThread(LinkedBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("waiting to take");
                    Integer num = queue.take();
                    System.out.println("task num: " + num);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
