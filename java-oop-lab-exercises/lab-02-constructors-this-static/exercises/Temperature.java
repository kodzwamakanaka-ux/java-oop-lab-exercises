// Assignment 2 (Lab 2) - Exercise 5 (Challenge)
public class Temperature {
    private final double celsius;

    private Temperature(double celsius) {   // private: callers must use the factories
        this.celsius = celsius;
    }

    public static Temperature fromCelsius(double c) {
        return new Temperature(c);
    }

    public static Temperature fromFahrenheit(double f) {
        return new Temperature((f - 32) * 5 / 9);
    }

    public double getCelsius()    { return celsius; }
    public double getFahrenheit() { return celsius * 9 / 5 + 32; }

    public static void main(String[] args) {
        Temperature t1 = Temperature.fromCelsius(100);
        Temperature t2 = Temperature.fromFahrenheit(32);
        System.out.printf("t1 = %.1f C = %.1f F%n", t1.getCelsius(), t1.getFahrenheit());
        System.out.printf("t2 = %.1f C = %.1f F%n", t2.getCelsius(), t2.getFahrenheit());

        /* WHY STATIC FACTORIES CAN BE CLEARER:
           Both constructors would be Temperature(double), so overloading cannot tell Celsius
           from Fahrenheit (same signature -> compile error). Factory methods have names, so
           fromCelsius(30) and fromFahrenheit(86) say exactly what the number means. */
    }
}
