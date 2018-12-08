package stack;

import java.util.EmptyStackException;

public class StackImplementation<E> implements Stack<E> {

    private Element<E> topElement;
    private int size;

    public E pop() {
        isEmpty();
        E oldTopElement = topElement.getItem();
        topElement = topElement.getElementUnder();
        size--;
        return oldTopElement;
    }

    public E peek() {
        isEmpty();
        return topElement.getItem();
    }

    public void push(E item) {
        Element tempElement = new Element(item);
        tempElement.setElementUnder(topElement);
        topElement = tempElement;
        size++;
    }

    public void clear() {
        topElement = new Element<>(null);
        size = 0;
    }

    private void isEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    //Only for checking the size of the stack
    @Override
    public String toString() {
        return String.valueOf(size);
    }

    private static class Element<E> {
        private E item;

        private Element<E> elementUnder;

        Element(E item) {
            this.item = item;
        }

        E getItem() {
            return item;
        }

        Element<E> getElementUnder() {
            return elementUnder;
        }

        void setElementUnder(Element<E> elementUnder) {
            this.elementUnder = elementUnder;
        }
    }

}
