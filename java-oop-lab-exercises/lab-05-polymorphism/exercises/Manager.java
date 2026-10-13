// Assignment 5 (Lab 5) - Exercise 3
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculatePay() { return super.calculatePay() + bonus; }
}
