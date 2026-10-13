// Assignment 5 (Lab 5) - Exercise 4 (Intermediate)
class Parent {
    String label = "Parent field";
    String who() { return "Parent method"; }
}

class Child extends Parent {
    String label = "Child field";            // HIDES the parent field (does not override it)
    @Override String who() { return "Child method"; }
}

public class FieldVsMethodDemo {
    public static void main(String[] args) {
        Parent ref = new Child();            // superclass reference to a Child object

        System.out.println(ref.who());       // Child method
        System.out.println(ref.label);       // Parent field

        System.out.println(((Child) ref).label);   // Child field (after casting)

        /* EXPLANATION:
           Methods are resolved at RUN TIME from the actual object (dynamic dispatch), so ref.who()
           runs Child's version. Fields are resolved at COMPILE TIME from the reference type, so
           ref.label uses Parent's field even though the object is a Child. Fields are not polymorphic. */
    }
}
