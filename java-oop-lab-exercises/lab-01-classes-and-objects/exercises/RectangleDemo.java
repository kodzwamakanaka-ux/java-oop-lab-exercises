// Assignment 1 (Lab 1) - Exercise 3: array of 5 rectangles, print the largest area
public class RectangleDemo {
    public static void main(String[] args) {
        Rectangle[] rects = {
            new Rectangle(2, 3),
            new Rectangle(5, 4),
            new Rectangle(1, 10),
            new Rectangle(7, 3),
            new Rectangle(6, 6)
        };

        Rectangle largest = rects[0];
        for (Rectangle r : rects) {
            if (r.area() > largest.area()) {
                largest = r;
            }
        }
        System.out.println("Largest rectangle: " + largest);
    }
}
