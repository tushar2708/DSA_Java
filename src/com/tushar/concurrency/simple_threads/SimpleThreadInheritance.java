package com.tushar.concurrency.simple_threads;

import java.util.concurrent.ConcurrentSkipListSet;

public class SimpleThreadInheritance {

    public static class NewThread extends Thread {

        @Override
        public void run() {
            System.out.println("Hello from " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // Option 1: Creating thread by implementing Runnable interface
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("a thread with name " + Thread.currentThread().getName() + " running...");
                System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
            }
        });


        System.out.println("running " + Thread.currentThread() + " before running new threads");
        th1.start();
        Thread.sleep(1000);
        System.out.println("running " + Thread.currentThread() + " again after running new threads");
    }
}
