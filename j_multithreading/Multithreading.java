package j_multithreading;

class Hello extends Thread {
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

class Bye extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            while (true) {
                System.out.println("Bye");
                Thread.sleep(2000);
            }
        } catch (Exception e) {
        }
    }
}

public class Multithreading {

    public static void multithreading() {
        new Hello().start();
        new Bye().start();
    }
}
