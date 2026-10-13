// Assignment 10 (Lab 10) - Exercise 1 (Basic): save five typed lines to a file, then read them back
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveAndReadLines {
    public static void main(String[] args) {
        Path file = Path.of("typed_lines.txt");
        Scanner in = new Scanner(System.in);

        List<String> lines = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            System.out.print("Line " + i + ": ");
            lines.add(in.hasNextLine() ? in.nextLine() : "");
        }

        try {
            Files.write(file, lines);                       // write
            System.out.println("\nSaved to " + file.toAbsolutePath());

            System.out.println("Reading back:");
            for (String line : Files.readAllLines(file)) {  // read
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
