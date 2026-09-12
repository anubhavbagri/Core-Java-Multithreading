package d_polymorphism;

// Code reusability: Encourages writing generic and reusable code by allowing a single interface to handle multiple types
// Extensibility: Allows easy extension of code by adding new classes / methods or overriding existing ones.

interface RoadVehicle {
  void start(); // Abstract method
}

// Implementing classes
class Auto implements RoadVehicle {
  @Override
  public void start() {
    System.out.println("Starting the auto");
  }
}

class Scooty implements RoadVehicle {
  @Override
  public void start() {
    System.out.println("Starting the scooty");
  }
}

// Adding a new type of Vehicle
class Bus implements RoadVehicle {
  @Override
  public void start() {
    System.out.println("Starting the Bus");
  }
}

public class Main3 {
    public static void main(String[] args) {
    RoadVehicle[] vehicles = {new Auto(), new Scooty(), new Bus()};
    for (RoadVehicle vehicle : vehicles) {
      vehicle.start(); // Polymorphic behavior (handles the new type seamlessly)
    }
  }
}
