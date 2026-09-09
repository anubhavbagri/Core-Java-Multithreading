package j_multithreading;

// Here the output is synchronized i.e. alternatively displaying hello then bye
// synchronized makes sure that thread cannot run both the blocks simultaneously, only one at a time
// boolean flag controls the alternate behaviour
// lock - unlock - signalling

public class Multithreading {
    public static boolean flag = true;

    static class Hello implements Runnable {
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

    static class Bye implements Runnable {
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
        Hello hello = new Hello();
        Thread th1 = new Thread(hello);
        th1.start();

        Bye bye = new Bye();
        Thread th2 = new Thread(bye);
        th2.start();
    }
}
