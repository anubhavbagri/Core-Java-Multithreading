package g_abstraction;

abstract class Animal {
    private String secret = "sensitive data";
    protected String name;

    Animal(String name) {
        this.name = name;
    }

    abstract void makeSound();

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void sleep() {
        System.out.println("Sleeping..");
    }

    protected String getSecret() {
        return secret; // controlled access to sensitive data
    }
}

class Dog extends Animal {

    Dog(String name) {
        // calls parent class constructor
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Bark");
        System.out.println("Accessing secret: " + getSecret());
    }
}

class Cat extends Animal {

    Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Meow");
    }
}

public class Main {
    public static void main(String args[]) {
        Animal myDog = new Dog("Tommy");
        myDog.makeSound();
        myDog.sleep();

        Animal myCat = new Cat("Pussy");
        myCat.makeSound();
        myCat.sleep();
    }
}
