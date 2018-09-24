package org.allen.sample.algorithm;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 数组实现栈
 */
public class StackDemo<T> {

    private static final int MAX_SIZE = 10;

    private Object[] array = new Object[MAX_SIZE];

    private Integer index = null;

    public void push(T a) {
        if (index == null) {
            index = 0;
            array[index] = a;
        } else {
            if (index < MAX_SIZE - 1) {
                index++;
                array[index] = a;
            } else{
                throw new IllegalArgumentException("stack is full");
            }
        }
    }

    public T peek() {
        if (index == null) {
            return null;
        }

        T a = (T)array[index];
        return a;
    }

    public T pop() {
        if (index == null) {
            throw new IllegalArgumentException("stack is empty");
        }

        T a = (T)array[index];
        array[index] = null;
        index--;
        if (index < 0) {
            index = null;
        }
        return a;
    }

    public Integer getIndex() {
        return index;
    }

    public static void main(String[] args) {
        StackDemo stackDemo = new StackDemo();
        stackDemo.push(5);
        stackDemo.push(4);
        System.out.println(stackDemo.pop());
        stackDemo.push(3);
        System.out.println(stackDemo.pop());
        System.out.println(stackDemo.pop());
        stackDemo.push(2);
        System.out.println(stackDemo.pop());

        validate();
    }

    private static void validate() {
        String text = "{}{{{}{{}}}";
        StackDemo<String> stackDemo = new StackDemo<String>();
        char[] array = text.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '{') {
                stackDemo.push("{");
            } else if (array[i] == '}'){
                if (stackDemo.peek() == "{"){
                    stackDemo.pop();
                } else {
                    System.out.println("no");
                }
            }
        }

        if (stackDemo.getIndex() == null) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static void queueToStack() {
        ArrayBlockingQueue<Integer> queueA = new ArrayBlockingQueue<Integer>(10);
        ArrayBlockingQueue<Integer> queueB = new ArrayBlockingQueue<Integer>(10);


    }
}
