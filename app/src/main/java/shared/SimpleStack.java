package shared;

import java.util.NoSuchElementException;

public interface SimpleStack<E> {

    int BLOCK = 100;
    int MAX_BLOCK = 10_000;

    /**
     * Adds an element to the top of the stack.
     * @param item The element to add.
     */
    void push(E item);

    /**
     * Removes and returns the element at the top of the stack
     * @return The top element.
     * @throws NoSuchElementException if the stack is empty
     */
    E pop();

    /**
     * Returns the element at the top of the stack without removing it
     * @return The top element.
     * @throws NoSuchElementException if the stack is empty
     */
    E peek();

    /**
     * Tests if the stack is empty.
     * @return true if the stack is empty, false otherwise.
     */
    boolean isEmpty();
}