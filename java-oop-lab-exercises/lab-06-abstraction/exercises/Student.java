// Assignment 6 (Lab 6) - Exercise 4 (Intermediate)
import java.util.Comparator;

public class Student implements Comparable<Student> {
    private final String name;
    private final int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public int getMarks()   { return marks; }

    // Natural ordering: by name (A to Z)
    @Override
    public int compareTo(Student other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    // Alternative ordering: by marks, highest first
    public static final Comparator<Student> BY_MARKS_DESC =
            Comparator.comparingInt(Student::getMarks).reversed();

    @Override
    public String toString() { return name + " (" + marks + ")"; }
}
