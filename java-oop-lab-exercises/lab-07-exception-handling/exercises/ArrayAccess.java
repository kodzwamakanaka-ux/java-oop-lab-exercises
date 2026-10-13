// Assignment 7 (Lab 7) - Exercise 2 (Basic)
public class ArrayAccess {
    static int getElement(int[] arr, int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index " + index + ": valid range is 0 to " + (arr.length - 1));
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        System.out.println("numbers[1] = " + getElement(numbers, 1));
        System.out.println("numbers[5] = " + getElement(numbers, 5));
    }
}
