// Assignment 8 (Lab 8) - Exercise 1 (Basic): ArrayList of 10 integers
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStats {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(14, 3, 27, 8, 45, 19, 2, 36, 11, 30));

        int sum = 0;
        for (int n : nums) sum += n;

        System.out.println("List:    " + nums);
        System.out.println("Sum:     " + sum);
        System.out.println("Maximum: " + Collections.max(nums));

        List<Integer> reversed = new ArrayList<>(nums);
        Collections.reverse(reversed);
        System.out.println("Reverse: " + reversed);
    }
}
