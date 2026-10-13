// Assignment 5 (Lab 5) - Exercise 2 (Basic)
public class Animal {
    public String sound() { return "..."; }
}

class Cat extends Animal {
    @Override public String sound() { return "Meow"; }
}

class Cow extends Animal {
    @Override public String sound() { return "Moo"; }
}

class Duck extends Animal {
    @Override public String sound() { return "Quack"; }
}
