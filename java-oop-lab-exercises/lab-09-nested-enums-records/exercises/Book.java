// Assignment 9 (Lab 9) - Exercise 3 (Intermediate): equals/hashCode by ISBN
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Book {
    private final String isbn;
    private final String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book other)) return false;
        return Objects.equals(isbn, other.isbn);      // identity = ISBN only
    }

    @Override
    public int hashCode() { return Objects.hash(isbn); }  // must be consistent with equals

    @Override
    public String toString() { return title + " [" + isbn + "]"; }

    public static void main(String[] args) {
        Set<Book> set = new HashSet<>();
        System.out.println("add 1st: " + set.add(new Book("978-0134685991", "Effective Java")));
        System.out.println("add 2nd (same ISBN, different object): "
                + set.add(new Book("978-0134685991", "Effective Java 3rd Ed")));
        System.out.println("add 3rd (new ISBN): " + set.add(new Book("978-0132350884", "Clean Code")));
        System.out.println("Set size = " + set.size() + " -> " + set);
        // false on the second add proves the HashSet rejected the duplicate.
    }
}
