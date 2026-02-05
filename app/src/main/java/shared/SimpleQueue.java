package shared;

import java.util.NoSuchElementException;

/**
 * Simple FIFO queue interface.
 *
 * @param <E> the type of elements held in this queue
 */
public interface SimpleQueue<E> {

    /**
     * Inserts the specified element at the tail of this queue.
     *
     * @param element the element to add
     */
    void enqueue(E element);

    /**
     * Removes and returns the head of this queue, or {@code null} if the queue is empty.
     *
     * @return the head element
     * @throws NoSuchElementException if the stack is empty
     */
    E dequeue();

    /**
     * Retrieves, but does not remove, the head of this queue, or {@code null} if the queue is empty.
     *
     * @return the head element
     * @throws NoSuchElementException if the stack is empty
     */
    E peek();

    /**
     * Returns {@code true} if this queue contains no elements.
     *
     * @return {@code true} if empty, {@code false} otherwise
     */
    boolean isEmpty();
}