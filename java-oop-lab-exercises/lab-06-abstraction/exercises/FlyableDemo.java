// Assignment 6 (Lab 6) - Exercise 2: Bird and Aeroplane share no superclass, only the interface
public class FlyableDemo {
    public static void main(String[] args) {
        Flyable[] things = { new Bird(), new Aeroplane() };
        for (Flyable f : things) f.fly();
    }
}
