class Hello extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Hello");
                // Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

class Bye extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Bye");
                // Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

public class Multithreading {
    public static void multithreading() {
        new Hello().start();
        new Bye().start();
    }

    public static void main(String[] args) {
        multithreading();
    }
}