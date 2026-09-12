package d_polymorphism;

// Polymorphism: "Many forms" - Same method name can behave differently depending on the object
// Compile time polymorphism/static Polymorphism/Early binding -> Method Overloading(same name, different signature):
// method to be executed is determined at compile time

class Vehicle {

  // Method to start a vehicle with basic information
  void start(String vehicleType) {
    System.out.println("Starting a " + vehicleType);
  }

  // Overloaded method to start a vehicle with extra information
  void start(String vehicleType, int speed) {
    System.out.println(
        "Starting a " + vehicleType + " with speed: " + speed + " km/h");
  }

  // Overloaded method to start a vehicle with an integer parameter
  void start(int vehicleId) {
    System.out.println("Starting a vehicle with ID: " + vehicleId);
  }
}

public class Main {
    public static void main(String[] args) {
    Vehicle vehicle = new Vehicle();

    // Calls method with one argument
    vehicle.start("Car");

    // Calls overloaded method with two arguments
    vehicle.start("Bike", 60);

    // Calls overloaded method with an integer argument
    vehicle.start(101);
  }
}
