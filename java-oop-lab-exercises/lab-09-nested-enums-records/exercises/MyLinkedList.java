// Assignment 9 (Lab 9) - Exercise 4 (Intermediate): static nested Node + inner Iterator
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {

    // Static nested class: a Node does not need access to a particular list object
    private static class Node<T> {
        T value;
        Node<T> next;
        Node(T value) { this.value = value; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int size() { return size; }

    // Inner (non-static) class: uses the enclosing list's 'head'
    private class ListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override public boolean hasNext() { return current != null; }

        @Override public T next() {
            if (current == null) throw new NoSuchElementException();
            T v = current.value;
            current = current.next;
            return v;
        }
    }

    @Override
    public Iterator<T> iterator() { return new ListIterator(); }

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("alpha");
        list.add("beta");
        list.add("gamma");

        for (String s : list) {            // works because the class is Iterable
            System.out.println(s);
        }
        System.out.println("size = " + list.size());
    }
}
