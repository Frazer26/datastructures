package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackImplementation<E> implements Stack<E> {

    private static final int INITIAL_CAPACITY = 0;

    private E elements[];

    public StackImplementation() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
    }

    public E pop() {
        if (elements.length < 1) {
            throw new EmptyStackException();
        }
        E topElement = elements[elements.length - 1];
        elements = Arrays.copyOf(elements, elements.length - 1);
        return topElement;
    }

    public E peek() {
        if (elements.length < 1) {
            throw new EmptyStackException();
        }
        return elements[elements.length - 1];
    }

    public void push(E item) {
        elements = Arrays.copyOf(elements, elements.length + 1);
        elements[elements.length - 1] = item;
    }

    public void clear() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

}
