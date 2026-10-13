// Assignment 5 (Lab 5) - Exercise 2: Animal[] holding different subclasses
public class AnimalDemo {
    public static void main(String[] args) {
        Animal[] zoo = { new Cat(), new Cow(), new Duck() };
        for (Animal a : zoo) {
            // Dynamic dispatch: the actual object decides which sound() runs
            System.out.println(a.getClass().getSimpleName() + " says " + a.sound());
        }
    }
}
