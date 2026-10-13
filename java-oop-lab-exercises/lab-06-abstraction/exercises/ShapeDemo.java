// Assignment 6 (Lab 6) - Exercise 1
public class ShapeDemo {
    public static void main(String[] args) {
        // Shape s = new Shape();   // compile error: Shape is abstract
        Shape[] shapes = { new Circle(3), new Rectangle(4, 5), new Square(2) };
        for (Shape s : shapes) System.out.println(s);
    }
}
