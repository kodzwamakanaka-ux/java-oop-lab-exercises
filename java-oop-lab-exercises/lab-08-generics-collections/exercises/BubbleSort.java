// Assignment 8 (Lab 8) - Exercise 5 (Challenge): generic bubble sort
import java.util.Arrays;

public class BubbleSort {

    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 2, 9, 1, 7};
        String[] words = {"pear", "apple", "mango", "banana"};

        bubbleSort(nums);
        bubbleSort(words);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(words));

        // int[] raw = {3, 1, 2};
        // bubbleSort(raw);   // COMPILE ERROR

        /* WHY int[] WILL NOT WORK:
           Generics only work with reference types. T must be a class such as Integer, and int is a
           primitive, so int[] is not a T[] (an int[] is not an Object[] either). Use Integer[] (boxing),
           or write a separate non-generic sort for int[]. */
    }
}
