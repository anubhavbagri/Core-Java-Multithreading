package j_multithreading;

public class Multithreading {

    public static void hello() throws Exception{
        while(true){
            System.out.println("Hello");
            Thread.sleep(1000);
        }
    }

    public static void bye() throws Exception{
        while(true){
            System.out.println("Bye");
            Thread.sleep(2000);
        }
    }
    public static void multithreading() throws Exception {
        hello();
        bye();
    }
}
