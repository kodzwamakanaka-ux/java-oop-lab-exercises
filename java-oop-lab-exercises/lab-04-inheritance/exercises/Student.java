// Assignment 4 (Lab 4) - Exercise 1 (Basic)
public class Student extends Person {
    private String course;

    public Student(String name, int age, String course) {
        super(name, age);
        this.course = course;
    }

    public String getCourse() { return course; }
}
