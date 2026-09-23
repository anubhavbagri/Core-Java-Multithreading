package l_designpatterns.creational;

interface Vehicle {
    void start();

    void stop();
}

class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike start");
    }

    @Override
    public void stop() {
        System.out.println("Bike stop");
    }
}

class Truck implements Vehicle {
    @Override
    public void start() {
        System.out.println("Truck start");
    }

    @Override
    public void stop() {
        System.out.println("Truck stop");
    }
}

// factory to create vehicles
// handles all logic of creating vehicles - cleaner & easier to maintain
// Provides a centralized place to hold & manage object creation based on any
// business logic
class VehicleFactory {
    public static Vehicle getVehicle(String vehicleType) {
        switch (vehicleType) {
            case "Bike":
                return new Bike();
            case "Truck":
                return new Truck();
            default:
                throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}

public class Factory {
    public static void main(String[] args) {
        // VehicleFactory obj = new VehicleFactory();

        Vehicle v1 = VehicleFactory.getVehicle("Bike");
        v1.start();
        v1.stop();

        Vehicle v2 = VehicleFactory.getVehicle("Truck");
        v2.start();
        v2.stop();
    }
}
