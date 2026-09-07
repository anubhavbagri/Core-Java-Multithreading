package com.java8.multithreading;

// using synchronized, wait and notify

public class Multithreading {
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
                synchronized (Multithreading.class) {
                    try {
                        while (!getFlag())
                            Multithreading.class.wait();
                        System.out.println(i + " odd");
                        setFlag(false);
                        Multithreading.class.notify();
                    } catch (Exception e) {
                    }
                }
        });

        Thread th2 = new Thread(() -> {
            for (int i = 2; i <= limit; i += 2)
                synchronized (Multithreading.class) {
                    try {
                        while (getFlag())
                            Multithreading.class.wait();
                        System.out.println(i + " even");
                        setFlag(true);
                        Multithreading.class.notify();
                    } catch (Exception e) {
                    }
                }
        });

        th1.start();
        th2.start();
    }
}