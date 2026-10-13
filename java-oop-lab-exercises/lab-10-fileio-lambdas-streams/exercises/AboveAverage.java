// Assignment 10 (Lab 10) - Exercise 4 (Intermediate): streams over a list of Student records
import java.util.List;

record Student(String name, int mark) { }

public class AboveAverage {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Tariro", 82),
                new Student("Farai", 55),
                new Student("Chipo", 91),
                new Student("Anesu", 48),
                new Student("Blessing", 70));

        double average = students.stream()
                .mapToInt(Student::mark)
                .average()
                .orElse(0);
        System.out.printf("Class average: %.1f%n", average);

        System.out.println("Above average (A-Z):");
        students.stream()
                .filter(s -> s.mark() > average)
                .map(Student::name)
                .sorted()
                .forEach(n -> System.out.println("  " + n));
    }
}
