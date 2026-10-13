// Assignment 2 (Lab 2) - Exercise 3 (Intermediate)
public class Employee {
    private static int nextId = 1;      // auto-incrementing counter

    private final int employeeId;
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.employeeId = nextId++;
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name) {
        this(name, 1000.0);
    }

    public Employee() {
        this("Unknown");
    }

    // Copy constructor: new id, same data
    public Employee(Employee other) {
        this(other.name, other.salary);
    }

    @Override
    public String toString() {
        return "Employee #" + employeeId + " " + name + " (" + salary + ")";
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Tendai", 2500);
        Employee e2 = new Employee("Rudo");
        Employee e3 = new Employee();
        Employee e4 = new Employee(e1);
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4 + "  <- copy of e1, own id");
    }
}
