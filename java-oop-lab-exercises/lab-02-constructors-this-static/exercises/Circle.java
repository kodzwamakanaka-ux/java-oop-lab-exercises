// Assignment 2 (Lab 2) - Exercises 1 and 2 (Basic)
public class Circle {
    private static int count = 0;      // shared by all circles
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        count++;
    }

    public Circle() {
        this(1.0);                      // default radius, chained constructor
    }

    public static int getCount() { return count; }
    public double area() { return Math.PI * radius * radius; }

    public static void main(String[] args) {
        Circle a = new Circle(2.5);
        Circle b = new Circle();
        System.out.printf("a area = %.2f, b area = %.2f%n", a.area(), b.area());
        System.out.println("Circles created: " + Circle.getCount());
    }
}
