// Assignment 4 (Lab 4) - Exercise 5 (Challenge): inheritance vs composition
import java.util.ArrayList;

// BAD: inheritance. A Stack IS-NOT-AN ArrayList, but this class claims it is.
class BadStack<T> extends ArrayList<T> {
    void push(T item) { add(item); }
    T pop()           { return remove(size() - 1); }
}

// GOOD: composition. The list is a hidden implementation detail.
class Stack<T> {
    private final ArrayList<T> items = new ArrayList<>();

    public void push(T item) { items.add(item); }

    public T pop() {
        if (items.isEmpty()) throw new IllegalStateException("Stack is empty");
        return items.remove(items.size() - 1);
    }

    public T peek() {
        if (items.isEmpty()) throw new IllegalStateException("Stack is empty");
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() { return items.isEmpty(); }
    public int size()        { return items.size(); }
}

public class StackDemo {
    public static void main(String[] args) {
        BadStack<String> bad = new BadStack<>();
        bad.push("A");
        bad.push("B");
        bad.push("C");
        bad.add(0, "SNEAKY");   // WRONG: inserts at the bottom, breaking LIFO
        bad.remove(1);          // WRONG: removes from the middle
        System.out.println("BadStack after illegal operations: " + bad);

        Stack<String> good = new Stack<>();
        good.push("A");
        good.push("B");
        good.push("C");
        // good.add(0, "X");    // does not compile: Stack only exposes push/pop/peek
        System.out.println("Good stack pop: " + good.pop() + ", peek: " + good.peek());

        /* WHAT THE INHERITANCE VERSION WRONGLY EXPOSES:
           add(index, e), remove(index), set, get(index), sort, clear and every other ArrayList method.
           Callers can insert or remove anywhere, which breaks the last-in-first-out rule.
           Composition exposes only push/pop/peek/isEmpty/size, so the rule cannot be broken, and we
           can swap ArrayList for another structure later without affecting callers. */
    }
}
