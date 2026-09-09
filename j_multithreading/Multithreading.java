package j_multithreading;

// Here the output is synchronized i.e. alternatively displaying odd then even with static inner class
// synchronized makes sure that thread cannot run both the blocks simultaneously, only one at a time
// boolean flag controls the alternate behaviour
// lock - unlock - signalling

public class Multithreading {
    public static boolean flag = true;
    public static int limit = 10;

    static class Odd implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= limit; i += 2)
                synchronized (Multithreading.class) {
                    try {
                        while (!flag)
                            Multithreading.class.wait();
                        System.out.println(i + " Odd");
                        flag = false;
                        Multithreading.class.notify();
                    } catch (Exception e) {
                    }
                }
        }
    }

    static class Even implements Runnable {
        @Override
        public void run() {
            for (int i = 2; i <= limit; i += 2)
                synchronized (Multithreading.class) {
                    try {
                        while (flag)
                            Multithreading.class.wait();
                        System.out.println(i + " Even");
                        flag = true;
                        Multithreading.class.notify();
                    } catch (Exception e) {
                    }
                }
        }
    }

    public static void multithreading() {
        Odd odd = new Odd();
        Thread th1 = new Thread(odd);
        th1.start();

        Even even = new Even();
        Thread th2 = new Thread(even);
        th2.start();
    }
}
