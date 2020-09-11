package com.tushar.concurrency.simple_threads;

public class SimpleThread {

    public static void main(String[] args) throws InterruptedException {

        // Option 1: Creating thread by implementing Runnable interface
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("a thread with name " + Thread.currentThread().getName() + " running...");
                System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
            }
        });

        // Option 2: Creating thread with statement lambda (also implements Runnable internally)
        Thread th2 = new Thread(() -> {
            System.out.println("another thread with name " + Thread.currentThread().getName() + " running...");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            throw new RuntimeException("throwing an intentional exception");
        });

        // Option 3: Creating thread with expression lambda, if there's only one statement
        Thread th3 = new Thread(() -> System.out.println("yet another thread with name " + Thread.currentThread().getName() + " running..."));

        th1.setPriority(Thread.MIN_PRIORITY);  // priority 1
        th2.setPriority(Thread.NORM_PRIORITY);   // priority 5
        th3.setPriority(Thread.MAX_PRIORITY);   // priority 10

        // Thread can also be given a name
        th1.setName("funny thread 1");

        // An exception handler can also be attached to a thread (this is also a Functional interface)
        // It handles any exeption that didn't get handled inside the thread's code
        th2.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("recovering from a thread's exception");
            }
        });

        System.out.println("running " + Thread.currentThread() + " before running new threads");
        th1.start();
        th2.start();
        th3.start();
        Thread.sleep(1000);
        System.out.println("running " + Thread.currentThread() + " again after running new threads");
    }
}
