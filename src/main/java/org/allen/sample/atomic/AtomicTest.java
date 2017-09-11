package org.allen.sample.atomic;


import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicTest {


    static enum State {
        NEW, INITIALIZING, INITIALIZED
    }

    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicReference<State> atomicReference = new AtomicReference<>(State.NEW);

        new Thread(new ThreadOne(atomicBoolean, atomicReference)).start();
        new Thread(new ThreadOne(atomicBoolean, atomicReference)).start();

    }

    static class ThreadOne implements Runnable {

        private AtomicBoolean flag;
        private AtomicReference<State> reference;

        ThreadOne(AtomicBoolean flag, AtomicReference<State> reference) {
            this.flag = flag;
            this.reference = reference;
        }

        @Override
        public void run() {
            boolean value = flag.get();
            System.out.println("thread: " + Thread.currentThread().getName() + " got flag: " + value);

            boolean succeed = flag.compareAndSet(true, false);
            if (succeed) {
                System.out.println("thread: " + Thread.currentThread().getName() + " got it");
                try {
                    Thread.sleep(500);
                    // DO SOMETHING
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("thread: " + Thread.currentThread().getName() + " miss it");
            }

            boolean succeed1 = reference.compareAndSet(State.NEW, State.INITIALIZING);
            if (succeed1) {
                System.out.println("thread: " + Thread.currentThread().getName() + " update status to " + State.INITIALIZING.name());
            } else {
                System.out.println("thread: " + Thread.currentThread().getName() + " nothing to do");
            }
        }
    }

}
