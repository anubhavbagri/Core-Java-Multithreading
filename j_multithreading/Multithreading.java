package j_multithreading;

class Hello implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            while (true) {
                System.out.println("Hello");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
        }
    }
}

class Bye implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            while (true) {
                System.out.println("Bye");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
        }
    }
}

public class Multithreading {

    public static void multithreading() {
        // create an instance of class that implement 'Runnable'
        Hello hello = new Hello();

        // pass the runnable obj to the thread constructor
        Thread th1 = new Thread(hello);

        // start the thread
        th1.start();

        Bye bye = new Bye();
        Thread th2 = new Thread(bye);

        th2.start();
    }
}
