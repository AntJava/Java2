package ru.gb.jtwo.elesson.online;

public class Main {

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            System.out.println(getName() + " started");
//            while(!isInterrupted());
            for (long i = 0; i < 10_000_000_000L; i++) {
                long a = i * 432;
            }
            System.out.println(getName() + " stopped");
        }
    }

    private static int a = 0;
    private static int b = 0;
    private static int c = 0;

    private static Object monitor = new Object();

    private static void increment() {
        synchronized (monitor) {
            for (int i = 0; i < 1_000_000; i++) {
                a = a + 1;
                b = b + 1;
                c = c + 1;
            }
            System.out.printf("a=%d, b=%d, c=%d\n", a, b, c);
        }
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                increment();
            }
        };

        new Thread(r, "Thread#1").start();
        new Thread(r, "Thread#2").start();
        new Thread(r, "Thread#3").start();
    }

    private static void joinExample() {
        System.out.println("main started");
        MyThread m0 = new MyThread("Thread--00");
        try {
            m0.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main wants to wait for m0");
    }

    private static void interruptExample() {
        System.out.println("main started");
        MyThread m0 = new MyThread("Thread--00");
        for (long i = 0; i < 10_000_000_000L; i++) {
            long a = i * 432;
        }
        System.out.println("Main wants to close m0 thread");
        m0.interrupt();
    }

    private static void initExamples() {
        new MyThread("Thread--01");
        new MyThread("Thread--02");
        new MyThread("Thread--03");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from runnable");
            }
        };
        Thread t = new Thread(r);
        t.start();

        System.out.println(Thread.currentThread().getName());
    }
}
