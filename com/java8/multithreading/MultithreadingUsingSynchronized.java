package com.java8.multithreading;

public class MultithreadingUsingSynchronized {
    boolean flag = true;
    int limit = 10;

    boolean getFlag() {
        return this.flag;
    }

    void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void multithreading() {

        Thread th1 = new Thread(() -> {
            for (int i = 1; i <= limit; i += 2)
                synchronized (MultithreadingUsingSynchronized.class) {
                    try {
                        while (!getFlag())
                            MultithreadingUsingSynchronized.class.wait();
                        System.out.println(i + " odd");
                        setFlag(false);
                        MultithreadingUsingSynchronized.class.notify();
                    } catch (Exception e) {
                    }
                }
        });

        Thread th2 = new Thread(() -> {
            for (int i = 2; i <= limit; i += 2)
                synchronized (MultithreadingUsingSynchronized.class) {
                    try {
                        while (getFlag())
                            MultithreadingUsingSynchronized.class.wait();
                        System.out.println(i + " even");
                        setFlag(true);
                        MultithreadingUsingSynchronized.class.notify();
                    } catch (Exception e) {
                    }
                }
        });

        th1.start();
        th2.start();
    }

    public static void main(String[] args) {
        new MultithreadingUsingSynchronized().multithreading();
    }
}