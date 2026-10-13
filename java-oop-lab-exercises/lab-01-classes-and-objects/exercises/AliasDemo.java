// Assignment 1 (Lab 1) - Exercise 4: references and aliasing
public class AliasDemo {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = r1;      // copies the REFERENCE, not the object
        r2.width = 10;

        // PREDICTION: prints 10.0 because r1 and r2 point to the same object.
        System.out.println("r1.width = " + r1.width);

        /* EXPLANATION (for the lab record):
           'Rectangle r2 = r1;' does not create a new Rectangle. It copies the address stored
           in r1 into r2, so both variables are aliases for one object on the heap.
           Changing r2.width therefore changes what r1 sees as well. */
    }
}
