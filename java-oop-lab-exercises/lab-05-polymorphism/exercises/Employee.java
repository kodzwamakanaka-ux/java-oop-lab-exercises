// Assignment 5 (Lab 5) - Exercise 3 (Intermediate): Lab 4 employee hierarchy
public class Employee {
    private final String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() { return name; }

    public double calculatePay() { return baseSalary; }

    public void describe() {
        System.out.printf("%s earns %.2f%n", name, calculatePay());
    }
}
