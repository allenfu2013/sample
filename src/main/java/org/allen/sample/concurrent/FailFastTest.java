package org.allen.sample.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * fail-fast 机制是java集合(Collection)中的一种错误机制。它只能被用来检测错误，因为JDK并不保证fail-fast机制一定会发生。
 * 当多个线程对同一个集合的内容进行操作时，就可能会产生fail-fast事件。
 * 例如：当某一个线程A通过iterator去遍历某集合的过程中，若该集合的内容被其他线程所改变了；那么线程A访问集合时，就会抛出ConcurrentModificationException异常，产生fail-fast事件。
 */
public class FailFastTest {


    public static void main(String[] args) {
        singleThread();
//        multiThread();
//        safeFail();
    }

    /**
     * fail-fast事件不是一定会发生，仅仅是尽最大努力抛出异常ConcurrentModificationException
     */
    public static void singleThread() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");

        for (String text : list) {
            System.out.println(text);
            list.add("one");
        }
    }

    public static void multiThread() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");


        new Thread(new ThreadOne(list)).start();
        new Thread(new ThreadTwo(list)).start();
    }

    public static void safeFail() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("one");
        list.add("two");

        new Thread(new ThreadOne(list)).start();  // 输出one, two
        new Thread(new ThreadTwo(list)).start();  // 输出one
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list);    //输出one
    }

    static class ThreadOne implements Runnable{
        private List<String> oneList;

        public ThreadOne(List<String> list) {
            oneList = list;
        }

        @Override
        public void run() {
            for (String text : oneList) {
                System.out.println(text);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadTwo implements Runnable {

        private List<String> twoList;

        public ThreadTwo(List<String> list) {
            twoList = list;
        }

        @Override
        public void run() {
            twoList.add("three");
            System.out.println(twoList);
        }
    }
}
