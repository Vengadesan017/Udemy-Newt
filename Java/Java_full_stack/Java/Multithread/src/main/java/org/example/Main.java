package org.example;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is in running state");
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " has finished execution");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.start();  // Start the thread

        MyThread thread2 = new MyThread();
        thread2.start();  // Start the thread
    }
}
