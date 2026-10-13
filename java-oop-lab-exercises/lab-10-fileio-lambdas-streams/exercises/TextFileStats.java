// Assignment 10 (Lab 10) - Exercise 3 (Intermediate): count lines, words and characters
// Usage: java TextFileStats [file]     (defaults to sample.txt)
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextFileStats {
    public static void main(String[] args) {
        Path file = Path.of(args.length > 0 ? args[0] : "sample.txt");
        try {
            List<String> lines = Files.readAllLines(file);

            int words = 0;
            int chars = 0;
            for (String line : lines) {
                String trimmed = line.trim();
                if (!trimmed.isEmpty()) words += trimmed.split("\\s+").length;
                chars += line.length();
            }

            System.out.println("File:       " + file);
            System.out.println("Lines:      " + lines.size());
            System.out.println("Words:      " + words);
            System.out.println("Characters: " + chars + " (excluding line breaks)");
        } catch (IOException e) {
            System.out.println("Could not read " + file + ": " + e.getMessage());
        }
    }
}
