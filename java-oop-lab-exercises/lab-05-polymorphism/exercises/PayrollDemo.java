// Assignment 5 (Lab 5) - Exercise 3: the payroll loop is NOT changed to support Intern
public class PayrollDemo {
    public static void main(String[] args) {
        Employee[] staff = {
            new Employee("Kudzai", 2000),
            new Manager("Nyasha", 3500, 800),
            new Developer("Tatenda", 3000, 10),
            new Intern("Chipo", 500)          // added without touching the loop below
        };

        double total = 0;
        for (Employee e : staff) {        // payroll loop: works for any Employee subtype
            e.describe();
            total += e.calculatePay();
        }
        System.out.printf("Total payroll: %.2f%n", total);
    }
}
