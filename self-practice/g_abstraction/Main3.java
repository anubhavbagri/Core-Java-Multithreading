package g_abstraction;

// What happens if a class implements an interface with a default method and
// also inherits the same method from a superclass? Which one gets priority?
// The method from the superclass takes priority over the default method in the interface
// The class will inherit the superclass's method unless it explicitly overrides it.

interface MasterAnimal {
  default void sound() {
    System.out.println("This is a default animal sound.");
  }
}

class Mammal {
  public void sound() {
    System.out.println("This is a mammal sound.");
  }
}

class Rabbit extends Mammal implements MasterAnimal {
  // No need to override sound
}

public class Main3 {
  public static void main(String[] args) {
    Rabbit rabbit = new Rabbit();
    rabbit.sound(); // Output: This is a mammal sound.

    Mammal mammal = new Rabbit();
    mammal.sound(); // same

    MasterAnimal ma = new Rabbit();
    ma.sound(); //same
  }
}

