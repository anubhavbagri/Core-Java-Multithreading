package com.java8.multithreading;

public class MultithreadingUsingSynchronized {
    public static boolean flag = true;
    public static int limit = 10;

    static class Hello extends Thread {
        public void run() {
            for (int i = 1; i <= limit; i += 2) synchronized (MultithreadingUsingSynchronized.class) {
                try {
                    while (!flag) MultithreadingUsingSynchronized.class.wait();
                    // System.out.println("Hello");
                    System.out.println(i + " odd");
                    flag = false;
                    MultithreadingUsingSynchronized.class.notify();
                } catch (Exception e) {}
            }
        }
    }

    static class Bye extends Thread {
        public void run() {
            for (int i = 2; i <= limit; i += 2) synchronized (MultithreadingUsingSynchronized.class) {
                try {
                    while (flag) MultithreadingUsingSynchronized.class.wait();
                    // System.out.println("Bye");
                    System.out.println(i + " even");
                    flag = true;
                    MultithreadingUsingSynchronized.class.notify();
                } catch (Exception e) {}
            }
        }
    }

    public static void multithreading() {
        new Hello().start();
        new Bye().start();
    }

    public static void main(String[] args) {
        multithreading();
    }
}