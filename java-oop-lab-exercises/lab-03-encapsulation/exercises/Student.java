// Assignment 3 (Lab 3) - Exercises 1 and 2 (Basic)
public class Student {
    private String name;
    private int marks;     // 0 to 100; grade is NOT stored, it is calculated

    public Student(String name, int marks) {
        this.name = name;
        setMarks(marks);
    }

    public String getName() { return name; }
    public int getMarks()   { return marks; }

    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        this.marks = marks;
    }

    public String getGrade() {
        if (marks >= 75) return "A";
        if (marks >= 60) return "B";
        if (marks >= 50) return "C";
        return "F";
    }

    public static void main(String[] args) {
        Student s = new Student("Tariro", 82);
        System.out.println(s.getName() + ": " + s.getMarks() + " -> " + s.getGrade());
        s.setMarks(55);
        System.out.println(s.getName() + ": " + s.getMarks() + " -> " + s.getGrade());
        try {
            s.setMarks(120);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
