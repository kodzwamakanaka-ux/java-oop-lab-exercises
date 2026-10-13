// Assignment 6 (Lab 6) - Exercise 1 (Basic): abstract class with abstract methods
public abstract class Shape {
    public abstract double area();
    public abstract double perimeter();

    @Override
    public String toString() {
        return String.format("%s: area=%.2f, perimeter=%.2f", getClass().getSimpleName(), area(), perimeter());
    }
}

class Circle extends Shape {
    private final double radius;
    Circle(double radius) { this.radius = radius; }
    @Override public double area()      { return Math.PI * radius * radius; }
    @Override public double perimeter() { return 2 * Math.PI * radius; }
}

class Rectangle extends Shape {
    private final double width, height;
    Rectangle(double width, double height) { this.width = width; this.height = height; }
    @Override public double area()      { return width * height; }
    @Override public double perimeter() { return 2 * (width + height); }
}

class Square extends Shape {
    private final double side;
    Square(double side) { this.side = side; }
    @Override public double area()      { return side * side; }
    @Override public double perimeter() { return 4 * side; }
}
