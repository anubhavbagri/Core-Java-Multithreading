package j_multithreading;

// Anonymous Inner Class
// This is what lambda is REALLY doing behind the scenes

// Thread constructor signature: public Thread(Runnable target)
// Lambda is just syntactic sugar for creating the Runnable on the spot

// creates a thread that executes code on a separate thread

public class Multithreading {
    public static boolean flag = true; // signals whose turn it is
    public static int limit = 10;

    public static void multithreading() {

        Thread oddTh = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= limit; i += 2)
                    synchronized (Multithreading.class) { // only one thread enters the block at a time
                        try {
                            while (!flag)
                                Multithreading.class.wait(); // threads take turns
                            System.out.println(i + " Odd");
                            flag = false;
                            Multithreading.class.notify(); // threads take turns
                        } catch (Exception e) {
                        }
                    }
            }
        });

        Thread evenTh = new Thread(new Runnable() {
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
        });

        oddTh.start();
        evenTh.start();
    }
}
