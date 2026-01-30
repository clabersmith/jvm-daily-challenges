import shared.SimpleStack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Day25 {

    public static <E> SimpleStack<E> getSimpleStack() {

        return new SimpleStack<E>() {
            //An ArrayList already handles resizing and supports generics,
            //but we'll do a T array instead to address more of the challenge
            int top = -1;  //current location of top of stack
            @SuppressWarnings("unchecked")
            E[] stack = (E[]) new Object[BLOCK];  //initialize the array to the first block size

            @Override
            public void push(E item) {
                if (top + 1 >= MAX_BLOCK) {
                    throw new IllegalStateException();
                }

                if (top + 1 >= stack.length) {
                    // resize the array within bounds
                    int newLen = Math.min(stack.length + BLOCK, MAX_BLOCK);
                    stack = Arrays.copyOf(stack, newLen);
                }

                stack[++top] = item;
            }

            @Override
            public E pop() {
                if (top < 0) {
                    throw new NoSuchElementException();
                }

                E item = stack[top];
                //remove the item reference to allow GC, prevent memory leak
                stack[top] = null;
                top -= 1;
                return item;
            }

            @Override
            public E peek() {
                if (top < 0) {
                    throw new NoSuchElementException();
                }

                return stack[top];
            }

            @Override
            public boolean isEmpty() {
                return top < 0;
            }
        };
    }
}
