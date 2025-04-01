package org.example;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0;

    public synchronized void increment_method() {
        count++;
    }
    public void increment_block() {
        synchronized(this) {  // Synchronize only this block
            count++;
        }
    }
    private final Lock lock = new ReentrantLock();
    public void increment() {
        lock.lock();  // Locking the resource
        try {
            count++;
        } finally {
            lock.unlock();  // Ensuring the lock is always released
        }
    }


    public int getCount() {
        return count;
    }
}
public class sysnchronization {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i + " from " + Thread.currentThread().getName());
                counter.increment();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}
