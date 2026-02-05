import shared.SimpleQueue
import java.util.Stack

fun <E> getSimpleQueue(): SimpleQueue<E> {
    return object : SimpleQueue<E> {
        //use two older, non-prod use legacy stacks to match challenge
        private val inStack: Stack<E> = Stack()
        private val outStack: Stack<E> = Stack()

        override fun enqueue(element: E) {
            inStack.push(element)
        }

        override fun dequeue(): E {
            refreshOutIfNeeded()
            if (outStack.isEmpty()) throw NoSuchElementException()
            return outStack.pop()
        }

        override fun peek(): E {
            refreshOutIfNeeded()
            if (outStack.isEmpty()) throw NoSuchElementException()
            return outStack.peek()
        }

        override fun isEmpty(): Boolean = inStack.isEmpty() && outStack.isEmpty()

        private fun refreshOutIfNeeded() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop())
                }
            }
        }
    }
}