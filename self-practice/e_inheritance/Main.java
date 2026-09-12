package e_inheritance;

// Multiple Inheritance is not supported in Java due to Diamond Problem, but it can be achieved using Interfaces
// When a class implements multiple interfaces, it must provide implementations for the methods defined in the interfaces
// This eliminates ambiguity since the child class explicitly defines the behavior of the inherited methods

interface Dog {
    default void sound() {
        System.out.println("Woof!");
    }
}

interface Cat {
    default void sound() {
        System.out.println("Meow!");
    }
}

// Without the override in HybridAnimal, Java doesn't know: does hybrid.sound() use Dog's woof or Cat's meow?
// That's the diamond problem. Your override resolves it explicitly.

class HybridAnimal implements Dog, Cat {

    // must override sound() and pick which super to call
    @Override
    public void sound(){
        // Must explicitly choose which default to call, OR define new behavior
        System.out.println("HybridAnimal says: ");
        Dog.super.sound();  // Calls Dog's default implementation
        Cat.super.sound();  // Calls Cat's default implementation
    }
}

public class Main {
    public static void main(String[] args) {
        HybridAnimal hybrid = new HybridAnimal();
        hybrid.sound();

        System.out.println("\n--- Direct interface calls ---");
        Dog dog = new HybridAnimal();
        dog.sound();  // Still uses HybridAnimal's override

        Cat cat = new HybridAnimal();
        cat.sound();  // Same
    }
}

/*
✅ Interfaces need default keyword to have an implementation
✅ Implementing class must override if two interfaces share a method
✅ Use InterfaceName.super.method() to call a specific interface's default
❌ This is NOT true multiple inheritance — it's a workaround that forces you to be explicit about which behavior you want
*/
// abstract methods have no body so you can't invoke them