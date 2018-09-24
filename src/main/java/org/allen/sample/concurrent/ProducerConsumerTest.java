package org.allen.sample.concurrent;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 在这个模型中，最关键就是内存缓冲区为空的时候消费者必须等待，而内存缓冲区满的时候，生产者必须等待。其他时候可以是个动态平衡。
 */
public class ProducerConsumerTest {

    static class Producer extends Thread {
        Queue<Integer> queue;
        int maxSize;

        Producer(Queue<Integer> queue, int maxSize, String name) {
            this.queue = queue;
            this.maxSize = maxSize;
            this.setName(name);
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }

                    System.out.println(this.getName() + "获得队列的锁");
                    //条件的判断一定要使用while而不是if
                    while (queue.size() == maxSize) {
                        System.out.println("队列已满，生产者" + this.getName() + "等待");
                        try {
                            queue.wait();
                        } catch (Exception e) {
                        }
                    }
                    int num = (int) (Math.random() * 100);
                    queue.offer(num);

                    System.out.println(this.getName() + "生产一个元素：" + num);
                    queue.notifyAll();

                    System.out.println(this.getName() + "退出一次生产过程！");
                }
            }
        }
    }

    public static class Consumer extends Thread {
        Queue<Integer> queue;
        int maxsize;

        Consumer(Queue<Integer> queue, int maxsize, String name) {
            this.queue = queue;
            this.maxsize = maxsize;
            this.setName(name);
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }

                    System.out.println(this.getName() + "获得队列的锁");
                    //条件的判断一定要使用while而不是if
                    while (queue.isEmpty()) {
                        System.out.println("队列为空，消费者" + this.getName() + "等待");
                        try {
                            queue.wait();
                        } catch (Exception e) {
                        }
                    }
                    int num = queue.poll();
                    System.out.println(this.getName() + "消费一个元素：" + num);
                    queue.notifyAll();

                    System.out.println(this.getName() + "退出一次消费过程！");
                }
            }
        }
    }

    public static void main(String[] args) {
        int maxsize = 2;
        Queue<Integer> queue = new ArrayBlockingQueue<Integer>(maxsize);

        Producer producer = new Producer(queue, maxsize, "Producer");
        Consumer consumer1 = new Consumer(queue, maxsize, "Consumer1");
        Consumer consumer2 = new Consumer(queue, maxsize, "Consumer2");
        Consumer consumer3 = new Consumer(queue, maxsize, "Consumer3");

        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
