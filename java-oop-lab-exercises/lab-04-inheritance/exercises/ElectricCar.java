// Assignment 4 (Lab 4) - Exercise 3
public class ElectricCar extends Car {
    public ElectricCar() {
        super();
        System.out.println("3. ElectricCar constructor");
    }

    public static void main(String[] args) {
        System.out.println("Creating an ElectricCar...");
        new ElectricCar();
        // Order is always top-down: Vehicle -> Car -> ElectricCar, because a subclass
        // object cannot exist until its superclass part has been built.
    }
}
