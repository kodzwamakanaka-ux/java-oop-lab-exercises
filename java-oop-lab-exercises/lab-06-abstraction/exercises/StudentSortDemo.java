// Assignment 6 (Lab 6) - Exercise 4
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentSortDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(
                new Student("Tariro", 82),
                new Student("Farai", 65),
                new Student("Chipo", 91),
                new Student("Anesu", 58)));

        Collections.sort(list);                       // uses compareTo (by name)
        System.out.println("By name:        " + list);

        list.sort(Student.BY_MARKS_DESC);             // uses the Comparator (by marks)
        System.out.println("By marks (desc): " + list);
    }
}
