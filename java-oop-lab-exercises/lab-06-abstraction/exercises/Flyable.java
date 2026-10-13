// Assignment 6 (Lab 6) - Exercise 2 (Basic): interface implemented by unrelated classes
public interface Flyable {
    void fly();
}

class Bird implements Flyable {
    @Override public void fly() { System.out.println("The bird flaps its wings and flies"); }
}

class Aeroplane implements Flyable {
    @Override public void fly() { System.out.println("The aeroplane takes off using jet engines"); }
}
