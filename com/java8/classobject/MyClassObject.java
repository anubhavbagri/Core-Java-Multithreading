package com.java8.classobject;

public class MyClassObject {
    private String name;

    public MyClassObject() {
        name = "Anubhav";
    }

    public MyClassObject(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "this is MyClassObject class";
    }
}
