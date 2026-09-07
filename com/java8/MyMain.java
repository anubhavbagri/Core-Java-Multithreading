package com.java8;

// import com.java8.classobject.MyClassObject;
import com.java8.multithreading.MultithreadingUsingSynchronized;

public class MyMain {
    public static void main(String[] args) {

        // MyClassObject obj = new MyClassObject("Subhradeep");
        // System.out.println(obj);
        // System.out.println(obj.getName());

        new MultithreadingUsingSynchronized().multithreading();
    }
}
