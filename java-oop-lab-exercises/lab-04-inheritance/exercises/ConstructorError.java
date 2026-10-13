// Assignment 4 (Lab 4) - Exercise 4 (Intermediate)
class Animal {
    String name;
    Animal(String name) {          // only constructor: no no-argument constructor exists
        this.name = name;
    }
}

/* BROKEN VERSION (does not compile), uncomment to see the error:

class Dog extends Animal {
    Dog() { }          // or no constructor at all
}

ERROR: constructor Animal in class Animal cannot be applied to given types;
       required: String  found: no arguments

WHY: every subclass constructor must call a superclass constructor as its first step. If you do not
write super(...), the compiler inserts super() with NO arguments. Animal has no such constructor
(writing Animal(String) removed the default one), so compilation fails.
FIX: call super(name) explicitly, as below. */

class Dog extends Animal {
    Dog(String name) {
        super(name);       // explicitly pick the constructor that exists
    }
}

public class ConstructorError {
    public static void main(String[] args) {
        Dog d = new Dog("Rex");
        System.out.println("Dog created: " + d.name);
    }
}
