// Assignment 7 (Lab 7) - Exercise 3 (Intermediate): custom CHECKED exception
public class InvalidAgeException extends Exception {   // extends Exception => checked
    public InvalidAgeException(String message) {
        super(message);
    }
}
