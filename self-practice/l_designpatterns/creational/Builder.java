package l_designpatterns.creational;

class Car {
    private String engine;
    private int seats;
    private boolean sunroof;

    // private constructor, ensuring its only created through the builder
    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.seats = builder.seats;
        this.sunroof = builder.sunroof;
    }

    // getter methods

    // public String getEngine() {
    // return engine;
    // }

    // public int getSeats() {
    // return seats;
    // }

    // public boolean isSunroof() {
    // return sunroof;
    // }

    @Override
    public String toString() {
        return "Car - engine " + engine + ", seats - " + seats + ", sunroof - " + sunroof;
    }

    // CarBuilder nested class [encapsulation: ]
    //
    public static class CarBuilder {
        // same attributes as Car but they are mutable
        private String engine;
        private int seats = 5; // default value
        private boolean sunroof = false; // default value

        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder setSeats(int seats) {
            this.seats = seats;
            return this;
        }

        public CarBuilder setSunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        // build method to create a Car object
        public Car build() {
            return new Car(this); // return a new Car created using the builder's values
        }
    }
}

public class Builder {
    public static void main(String[] args) {
        // creating the car using the builder pattern
        Car.CarBuilder builder = new Car.CarBuilder();
        Car car1 = builder.setEngine("v8")
                .setSunroof(true)
                .build(); // the build method returns the final product

        System.out.println(car1);
    }
}
