// Assignment 4 (Lab 4) - Exercises 1 and 2: Student and Teacher both reuse Person.display()
public class PersonDemo {
    public static void main(String[] args) {
        Person p = new Person("Kudzai", 40);
        Student s = new Student("Tariro", 20, "Computer Science");
        Teacher t = new Teacher("Mr Moyo", 45, "Java");

        p.display();
        s.display();   // inherited, no code rewritten in Student
        t.display();   // inherited, no code rewritten in Teacher
        System.out.println("Student course: " + s.getCourse() + ", Teacher subject: " + t.getSubject());
    }
}
