// Assignment 8 (Lab 8) - Exercise 3 (Intermediate): generic Stack<T> backed by ArrayList<T>
import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private final List<T> items = new ArrayList<>();

    public void push(T item) { items.add(item); }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return items.remove(items.size() - 1);
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() { return items.isEmpty(); }

    public static void main(String[] args) {
        Stack<String> words = new Stack<>();
        words.push("one");
        words.push("two");
        words.push("three");
        System.out.println("peek: " + words.peek());
        while (!words.isEmpty()) System.out.println("pop: " + words.pop());

        Stack<Integer> numbers = new Stack<>();   // same class, different type, type-safe
        numbers.push(10);
        numbers.push(20);
        System.out.println("pop: " + numbers.pop());
    }
}
