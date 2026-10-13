// Assignment 8 (Lab 8) - Exercise 2 (Basic): a Set rejects duplicates
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> names = List.of("Tariro", "Farai", "Tariro", "Chipo", "Farai", "Anesu");

        // LinkedHashSet keeps the original order of first appearance
        Set<String> unique = new LinkedHashSet<>(names);

        System.out.println("Original: " + names);
        System.out.println("Unique:   " + unique);
    }
}
