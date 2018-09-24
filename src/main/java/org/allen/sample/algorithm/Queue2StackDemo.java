package org.allen.sample.algorithm;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Queue2StackDemo<E> {

    private Queue<E> queueA = new ArrayBlockingQueue<E>(10);
    private Queue<E> queueB = new ArrayBlockingQueue<E>(10);
    private Queue<E> queue = queueA;
    private String flag = "A";

    public E push(E e) {
        if (queue.isEmpty()) {
            queue.add(e);
        } else {
            Queue<E> to = null;
            if (flag == "A") {
                queueB.add(e);
                to = queueB;
                flag = "B";
            } else {
                queueA.add(e);
                to = queueA;
                flag = "A";
            }
            transform(queue, to);
            queue = to;
        }
        return e;
    }

    public E pop() {
        if (!queue.isEmpty()) {
            return queue.poll();
        } else {
            throw new IllegalStateException("queue is empty");
        }
    }

    private void transform(Queue<E> from, Queue<E> to){
        E e = from.poll();
        while (e != null) {
            to.add(e);
            e = from.poll();
        }
    }

    public static void main(String[] args) {
        Queue2StackDemo demo = new Queue2StackDemo();
        demo.push(1);
        demo.push(2);
        System.out.println("dddd");
        System.out.println(demo.pop());
        demo.push(3);
        System.out.println(demo.pop());
        System.out.println(demo.pop());
    }
}
