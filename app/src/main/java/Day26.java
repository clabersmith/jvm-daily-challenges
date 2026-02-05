import shared.SimpleQueue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class Day26 {
    public static <E> SimpleQueue<E> getSimpleQueue() {
        /*
          Returns a SimpleQueue implementation backed by two stacks.
          Enqueue is O(1), but dequeue and peek may be O(n) when elements are moved between stacks,
          making those operations potentially costly.
         */
        return new SimpleQueue<E>() {
            //use two older, non-prod use legacy stacks to match challenge
            final Stack<E> in = new Stack<>();
            final Stack<E> out = new Stack<>();

            @Override
            public void enqueue(E element) {
                in.push(element);
            }

            @Override
            public E dequeue() {
                refreshOutStackIfNeeded();

                if (out.isEmpty()) {
                    throw new NoSuchElementException();
                }

                return out.pop();
            }

            @Override
            public E peek() {
                refreshOutStackIfNeeded();

                if (out.isEmpty()) {
                    throw new NoSuchElementException();
                }

                return out.peek();
            }

            @Override
            public boolean isEmpty() {
                return out.isEmpty() && in.isEmpty();
            }

            private void refreshOutStackIfNeeded() {
                //push any new in elements to the out stack if empty to maintain reverse order
                if(out.isEmpty()) {
                    while(!in.isEmpty()) {
                        out.push(in.pop());
                    }
                }
            }
        };
    }
}
