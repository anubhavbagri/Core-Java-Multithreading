package a_objects;

class Car {
	    // Attributes :
	    String manufacturer;
	    String model;
	    int year;

	    // Constructor :
	    public Car(String manufacturer, String model, int year) {
	        this.manufacturer = manufacturer;
	        this.model = model;
	        this.year = year;
	    }

	    // Methods :
	    public void startEngine() {
	        System.out.println("The " + year + " " + manufacturer + " " + model + "'s engine has started.");
	    }
	    public void displayInfo() {
	        System.out.println("Car Info: " + manufacturer + " " + model + " (" + year + ")");
	    }
}

public class Main {
    public static void main(String[] args) {

        // Creating objects
        Car car1 = new Car("Toyota", "Corolla", 2021);
        Car car2 = new Car("Honda", "Civic", 2022);

        // Using objects
        car1.startEngine();  // Output: The 2021 Toyota Corolla's engine has started.
        car2.startEngine();  // Output: The 2022 Honda Civic's engine has started.
        car1.displayInfo();  // Output: Car Info: Toyota Corolla (2021)
        car2.displayInfo();  // Output: Car Info: Honda Civic (2022)
    }
}
