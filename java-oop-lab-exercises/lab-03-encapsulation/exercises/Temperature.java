// Assignment 3 (Lab 3) - Exercise 5 (Challenge)
public class Temperature {
    private static final double ABSOLUTE_ZERO_K = 0.0;

    // Internal representation: kelvin. Callers never see this field.
    private double kelvin;

    public Temperature(double celsius) {
        setCelsius(celsius);
    }

    public double getCelsius()    { return kelvin - 273.15; }
    public double getFahrenheit() { return getCelsius() * 9 / 5 + 32; }

    public void setCelsius(double celsius) {
        double k = celsius + 273.15;
        if (k < ABSOLUTE_ZERO_K) {
            throw new IllegalArgumentException("Below absolute zero (-273.15 C)");
        }
        this.kelvin = k;
    }

    public static void main(String[] args) {
        Temperature t = new Temperature(25);
        System.out.printf("%.2f C = %.2f F%n", t.getCelsius(), t.getFahrenheit());
        try {
            t.setCelsius(-300);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        /* WHY CHANGING THE INTERNAL UNIT WOULD NOT BREAK CALLERS:
           The field is private, so callers only use getCelsius(), getFahrenheit() and setCelsius().
           If kelvin were replaced by a Celsius or Fahrenheit field, only the bodies of these methods
           change. Their signatures and results stay identical, so no calling code needs editing. */
    }
}
