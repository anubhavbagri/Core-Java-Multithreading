package j_multithreading;

// Here the output is synchronized i.e. alternatively displaying hello then bye
// synchronized makes sure that thread cannot run both the blocks simultaneously, only one at a time
// boolean flag controls the alternate behaviour
// lock - unlock - signalling

public class Multithreading {
    public static boolean flag = true;

    static class Hello extends Thread {
        @Override
        public void run() {
            while (true)
                synchronized (Multithreading.class) {
                    try {
                        while (!flag)
                            Multithreading.class.wait();
                        System.out.println("Hello");
                        flag = false;
                        Multithreading.class.notify();
                    } catch (Exception e) {
                    }
                }
        }
    }

    static class Bye extends Thread {
        @Override
        public void run() {
            while (true)
                synchronized (Multithreading.class) {
                    try {
                        while (flag)
                            Multithreading.class.wait();
                        System.out.println("Bye");
                        flag = true;
                        Multithreading.class.notify();
                    } catch (Exception e) {
                    }
                }
        }
    }

    public static void multithreading() {
        new Hello().start();
        new Bye().start();
    }
}
