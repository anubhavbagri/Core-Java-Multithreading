package j_multithreading;

// The Thread constructor takes a Runnable - a functional interface with one method: void run()
// new Thread(() -> {}) : you're passing a lambda that implements Runnnable, the lambda body becomes the run() method
// It's exactly the same as new Thread(new Runnable() { public void run() { ... } }), just shorter.

public class Multithreading {
    public static boolean flag = true;
    public static int limit = 10;

    public static void multithreading() {

        Thread oddTh = new Thread(() -> {   //Lambda = Runnable Implementation
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
        });

        Thread evenTh = new Thread(() -> {  //Lambda = Runnable Implementation
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
        });

        oddTh.start();
        evenTh.start();
    }
}
