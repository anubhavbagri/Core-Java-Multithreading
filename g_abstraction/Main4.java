package g_abstraction;

// If a class implements two interfaces with the same default method, it must override the method to resolve the ambiguity explicitly

interface DogBehavior {
  default void makeSound() {
    System.out.println("Dog barks.");
  }
}

interface CatBehavior {
  default void makeSound() {
    System.out.println("Cat meows.");
  }
}

class AnimalProcessor implements DogBehavior, CatBehavior {
  // Resolving the conflict by overriding the method
  @Override
  public void makeSound() {
    System.out.println(
        "Resolving conflict between DogBehavior and CatBehavior:");

    // Call the default method from DogBehavior
    DogBehavior.super.makeSound();

    // Call the default method from CatBehavior
    CatBehavior.super.makeSound();

    // Adding custom behavior
    System.out.println(
        "Custom behavior: AnimalProcessor decides which sound to make.");
  }
}

public class Main4 {
  public static void main(String[] args) {
    AnimalProcessor processor = new AnimalProcessor();
    processor.makeSound();
  }
}

