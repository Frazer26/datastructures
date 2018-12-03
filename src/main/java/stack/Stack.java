package stack;

public interface Stack<E> {
    /**
     * pop out the first item and removes it
     *
     * @return
     */
    E pop();

    /**
     * read the first item but keeps it
     *
     * @return
     */
    E peek();

    /**
     * add new item
     *
     * @param item
     */
    void push(E item);

    /**
     * clear the stack
     */
    void clear();
}
