// Assignment 10 (Lab 10) - Exercise 5 (Challenge): load learners.csv, group by band, write one report per band
// Bands: A = 70 and above, B = 50 to 69, C = below 50
// Run from this folder so that learners.csv is found. Reports are written to the "reports" folder.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GradeBands {

    record Learner(String name, int mark) {
        String band() {
            if (mark >= 70) return "A";
            if (mark >= 50) return "B";
            return "C";
        }
    }

    static List<Learner> load(Path csv) throws IOException {
        List<Learner> learners = new ArrayList<>();
        List<String> lines = Files.readAllLines(csv);
        for (int i = 1; i < lines.size(); i++) {           // skip header row
            String line = lines.get(i).trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split(",");
            learners.add(new Learner(parts[0].trim(), Integer.parseInt(parts[1].trim())));
        }
        return learners;
    }

    public static void main(String[] args) {
        try {
            List<Learner> learners = load(Path.of("learners.csv"));

            Map<String, List<Learner>> byBand = learners.stream()
                    .collect(Collectors.groupingBy(Learner::band));

            Path outDir = Path.of("reports");
            Files.createDirectories(outDir);

            for (String band : List.of("A", "B", "C")) {
                List<Learner> group = byBand.getOrDefault(band, List.of());
                List<String> report = new ArrayList<>();
                report.add("Band " + band + " report (" + group.size() + " learners)");
                group.stream()
                        .sorted((x, y) -> Integer.compare(y.mark(), x.mark()))
                        .forEach(l -> report.add(l.name() + " - " + l.mark()));

                Path file = outDir.resolve("band_" + band + ".txt");
                Files.write(file, report);
                System.out.println("Wrote " + file + " (" + group.size() + " learners)");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
