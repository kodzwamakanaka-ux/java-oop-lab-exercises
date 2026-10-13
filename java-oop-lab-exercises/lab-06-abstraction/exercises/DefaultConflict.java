// Assignment 6 (Lab 6) - Exercise 5 (Challenge)
interface Greeter {
    default void hello() { System.out.println("Hello from Greeter"); }
}

interface Welcomer {
    default void hello() { System.out.println("Hello from Welcomer"); }
}

class Receptionist implements Greeter, Welcomer {
    // Both interfaces supply hello(), so the compiler forces us to resolve the clash.
    @Override
    public void hello() {
        Greeter.super.hello();      // choose one explicitly...
        Welcomer.super.hello();     // ...or call both
    }
}

public class DefaultConflict {
    public static void main(String[] args) {
        new Receptionist().hello();

        /* THE RULE:
           If a class inherits two default methods with the same signature from different interfaces,
           the code does not compile unless the class overrides the method. Inside the override you can
           pick a version with InterfaceName.super.method(). (If the class or a superclass declares the
           method itself, that always wins over interface defaults: "class wins" rule.) */
    }
}
