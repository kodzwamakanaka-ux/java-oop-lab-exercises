// Assignment 1 (Lab 1) - Exercises 1 and 2: runs the Car class
public class CarDemo {
    public static void main(String[] args) {
        Car c1 = new Car("Toyota", 1995, 250000);
        Car c2 = new Car("Honda", 2015, 90000);
        Car c3 = new Car("Mazda", 2022, 15000);

        Car[] cars = {c1, c2, c3};
        for (Car c : cars) {
            c.display();
            System.out.println("  Antique? " + c.isAntique());
        }
    }
}
