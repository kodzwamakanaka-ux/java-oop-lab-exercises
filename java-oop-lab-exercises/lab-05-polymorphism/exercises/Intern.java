// Assignment 5 (Lab 5) - Exercise 3: the NEW subclass
public class Intern extends Employee {
    private static final double STIPEND_ALLOWANCE = 150.0;

    public Intern(String name, double stipend) {
        super(name, stipend);
    }

    @Override
    public double calculatePay() { return baseSalary + STIPEND_ALLOWANCE; }
}
