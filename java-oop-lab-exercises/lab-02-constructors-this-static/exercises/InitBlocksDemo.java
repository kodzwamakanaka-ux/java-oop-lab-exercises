// Assignment 2 (Lab 2) - Exercise 4 (Intermediate)
// PREDICTED OUTPUT:
//   static block 1
//   static block 2
//   --- creating object ---
//   instance block 1
//   instance block 2
//   constructor
// Static blocks run once at class load, in order. Instance blocks run before the
// constructor body for every object, in the order written.
public class InitBlocksDemo {
    static { System.out.println("static block 1"); }
    static { System.out.println("static block 2"); }

    { System.out.println("instance block 1"); }
    { System.out.println("instance block 2"); }

    InitBlocksDemo() { System.out.println("constructor"); }

    public static void main(String[] args) {
        System.out.println("--- creating object ---");
        new InitBlocksDemo();
    }
}
