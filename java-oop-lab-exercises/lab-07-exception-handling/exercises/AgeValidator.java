// Assignment 7 (Lab 7) - Exercise 3
public class AgeValidator {
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age " + age + " is outside the valid range 0-120");
        }
        System.out.println("Age " + age + " is valid");
    }

    public static void main(String[] args) {
        int[] tests = {25, -3, 130, 0, 120};
        for (int age : tests) {
            try {
                validateAge(age);              // compiler FORCES us to handle the checked exception
            } catch (InvalidAgeException e) {
                System.out.println("Rejected: " + e.getMessage());
            }
        }
    }
}
