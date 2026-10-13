// Assignment 8 (Lab 8) - Exercise 4 (Intermediate): word frequencies, sorted by frequency descending
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "the quick brown fox jumps over the lazy dog. The dog barks and the fox runs away.";

        Map<String, Integer> freq = new HashMap<>();
        for (String word : paragraph.toLowerCase().split("\\W+")) {
            if (word.isEmpty()) continue;
            freq.merge(word, 1, Integer::sum);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());
        // highest count first; ties broken alphabetically
        entries.sort((a, b) -> {
            int byCount = Integer.compare(b.getValue(), a.getValue());
            return byCount != 0 ? byCount : a.getKey().compareTo(b.getKey());
        });

        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}
