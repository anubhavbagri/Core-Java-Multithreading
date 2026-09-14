package com.java8.classobject;

interface A1 {
    void display();

    default void show() {
        System.out.println("A1");
    }

    static void print() {
        System.out.println("static method in A1");
    }
}

interface A2 {
    void display(String name);

    default void show() {
        System.out.println("A2");
    }
}

class B {
    public void show() {
        System.out.println("B");
    }
}

class C extends B implements A1, A2 {
    @Override
    public void display(String name) {
        System.out.println("Hello World");
        ;
    }

    @Override
    public void display() {
        System.out.println();
    }

}

public class example {
    public static void main(String[] args) {
        C obj = new C();
        obj.show();
        A1.print();

        A2 obj1 = (name) -> {
            System.out.println("Lambda: A2 " + name);
        };
        obj1.display("Anubhav");
    }
}
