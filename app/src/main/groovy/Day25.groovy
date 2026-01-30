import shared.SimpleStack

class Day25Groovy {
    static <E> SimpleStack<E> getSimpleStack() {
        new SimpleStack<E>() {
            int top = -1
            @SuppressWarnings('unchecked')
            E[] stack = (E[]) new Object[BLOCK]

            @Override
            void push(E item) {
                if (top + 1 >= MAX_BLOCK) throw new IllegalStateException()
                if (top + 1 >= stack.length) {
                    int newLen = Math.min(stack.length + BLOCK, MAX_BLOCK)
                    stack = Arrays.copyOf(stack, newLen) as E[]
                }
                stack[++top] = item
            }

            @Override
            E pop() {
                if (top < 0) throw new NoSuchElementException()
                E item = stack[top]
                stack[top] = null
                top--
                item
            }

            @Override
            E peek() {
                if (top < 0) throw new NoSuchElementException()
                stack[top]
            }

            @Override
            boolean isEmpty() { top < 0 }
        }
    }
}
