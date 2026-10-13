// Assignment 1 (Lab 1) - Exercises 1 and 2 (Basic)
import java.time.Year;

public class Car {
    String brand;
    int year;
    double mileage;

    Car(String brand, int year, double mileage) {
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
    }

    void display() {
        System.out.println("Brand: " + brand + ", Year: " + year + ", Mileage: " + mileage + " km");
    }

    // Exercise 2: antique if more than 25 years old
    boolean isAntique() {
        return Year.now().getValue() - year > 25;
    }
}
