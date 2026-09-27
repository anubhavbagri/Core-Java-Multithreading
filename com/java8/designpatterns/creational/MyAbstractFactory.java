package com.java8.designpatterns.creational;

interface Vehicle {
  void start();

  void stop();
}

// Concrete Classes for Car Brands
class Honda implements Vehicle {
  public void start() {
    System.out.println("Honda Car is starting");
  }

  public void stop() {
    System.out.println("Honda Car is stopping");
  }
}

class Toyota implements Vehicle {
  public void start() {
    System.out.println("Toyota Car is starting");
  }

  public void stop() {
    System.out.println("Toyota Car is stopping");
  }
}

class BMW implements Vehicle {
  public void start() {
    System.out.println("BMW Car is starting");
  }

  public void stop() {
    System.out.println("BMW Car is stopping");
  }
}

// abstract factory interface
interface VehicleFactory {
  Vehicle getVehicle();
}

// concrete factories for Each Car brand
class HondaFactory implements VehicleFactory {
  @Override
  public Vehicle getVehicle() {
    return new Honda();
  }
}

class ToyotaFactory implements VehicleFactory {
  @Override
  public Vehicle getVehicle() {
    return new Toyota();
  }
}

class BMWFactory implements VehicleFactory {
  @Override
  public Vehicle getVehicle() {
    return new BMW();
  }
}

public class MyAbstractFactory {
  public static void main(String[] args) {
    VehicleFactory hondaFactory = new HondaFactory();
    Vehicle obj = hondaFactory.getVehicle();

    obj.start();
    obj.stop();

    VehicleFactory BMWFactory = new BMWFactory();
    Vehicle bmw = BMWFactory.getVehicle();

    bmw.start();
    bmw.stop();
  }

}
