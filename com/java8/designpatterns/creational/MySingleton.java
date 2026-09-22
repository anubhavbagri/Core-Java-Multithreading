package com.java8.designpatterns.creational;

class A {
    static void display() {
        System.out.println("A");
    }
}

class B {
    private static volatile B obj;

    private B() {
    }

    static B getB() {
        synchronized (B.class) {
            if (obj == null) {
                obj = new B();
            }
        }
        return obj;
    }

    void show() {
        System.out.println("B");
    }
}

public class MySingleton {
    public static void singleton() {
        A.display();
        A.display();
        A.display();

        B B1 = B.getB();
        B B2 = B.getB();
        B B3 = B.getB();

        B1.show();
        B2.show();
        B3.show();

        System.out.println((B1 == B2) + " " + (B1 != B2));
    }
}
