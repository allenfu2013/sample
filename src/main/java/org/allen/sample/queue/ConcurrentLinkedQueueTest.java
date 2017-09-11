package org.allen.sample.queue;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 基于链接节点的无界线程安全队列
 */
public class ConcurrentLinkedQueueTest {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        new Thread(new AddThread(queue)).start();
        new Thread(new PollThread(queue)).start();
    }

    static class AddThread implements Runnable {

        ConcurrentLinkedQueue<Integer> queue = null;

        AddThread(ConcurrentLinkedQueue<Integer> queue) {
            this.queue = queue;
        }


        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("ready to add");
                    int num = new Random().nextInt(100);
                    queue.add(num);
                    System.out.println("add num: " + num);
//                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class PollThread implements Runnable {

        ConcurrentLinkedQueue<Integer> queue = null;

        public PollThread(ConcurrentLinkedQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("waiting to poll");
                    Integer num = queue.poll();
                    System.out.println("poll num: " + num);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
