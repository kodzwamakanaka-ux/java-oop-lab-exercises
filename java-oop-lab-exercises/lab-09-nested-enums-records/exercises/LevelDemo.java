// Assignment 9 (Lab 9) - Exercise 1 (Basic): enum with switch
enum Level { LOW, MEDIUM, HIGH }

public class LevelDemo {
    static void advice(Level level) {
        switch (level) {
            case LOW    -> System.out.println("LOW: relax, nothing urgent.");
            case MEDIUM -> System.out.println("MEDIUM: plan your work and keep going.");
            case HIGH   -> System.out.println("HIGH: act now, this needs attention!");
        }
    }

    public static void main(String[] args) {
        for (Level l : Level.values()) advice(l);
    }
}
