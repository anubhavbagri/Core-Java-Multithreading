package d_polymorphism;

// Run time polymorphism/dynamic Polymorphism/Late binding -> Method Overriding: Occurs in inheritance
// Child class provides specific implementation of parent class method - overridden method has same name, same signature
// method to be executed is determined at runtime based on the actual object type.
// Supports dynamic method dispatch, enabling JVM to determine the appropriate method implementation.

// Parent class
class BaseVehicle {
  void start() {
    System.out.println("Starting a generic vehicle");
  }
}

// Subclasses overriding the start method
class Car extends BaseVehicle {
  @Override
  void start() {
    System.out.println("Starting a car");
  }
}

class Bike extends BaseVehicle {
  @Override
  void start() {
    System.out.println("Starting a bike");
  }
}

class Truck extends BaseVehicle {
  @Override
  void start() {
    System.out.println("Starting a truck");
  }
}

public class Main2 {
  public static void main(String[] args) {
    BaseVehicle myVehicle;

    // Flexible: Dynamically assign different types of vehicles

    // Assign a Car object to the Vehicle reference
    myVehicle = new Car();
    myVehicle.start(); // Output: Starting a car

    // Assign a Bike object to the Vehicle reference
    myVehicle = new Bike();
    myVehicle.start(); // Output: Starting a bike

    // Assign a Truck object to the Vehicle reference
    myVehicle = new Truck();
    myVehicle.start(); // Output: Starting a truck
  }
}
