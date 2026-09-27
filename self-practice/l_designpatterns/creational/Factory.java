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

// separate class whose only job is to centralize
// and encapsulate object creation
class SimpleVehicleFactory {
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

        Vehicle v1 = SimpleVehicleFactory.getVehicle("Bike");
        v1.start();
        v1.stop();

        Vehicle v2 = SimpleVehicleFactory.getVehicle("Truck");
        v2.start();
        v2.stop();
    }
}
