package e_inheritance;

// Hybrid Inheritance - involves both single inheritance (class) & multiple inheritance (using interfaces)

// Single inheritance
class Animal {
  void eat() {
    System.out.println("The animal eats food.");
  }
}

// Interface for multiple inheritance
interface Mammal {
  void walk();
}

// Interface for multiple inheritance
interface Pet {
  void play();
}

// Hybrid inheritance using a combination of class and interfaces
class Horse extends Animal implements Mammal, Pet {
  @Override
  void eat() {
    System.out.println("The horse eats food.");
  }
  @Override
  public void walk() {
    System.out.println("The horse walks.");
  }
  @Override
  public void play() {
    System.out.println("The horse plays polo.");
  }
}

public class Main2 {
    public static void main(String[] args) {
    Horse horse = new Horse();
    horse.eat();
    horse.walk();
    horse.play();
  }
}
