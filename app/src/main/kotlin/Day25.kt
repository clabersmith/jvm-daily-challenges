import shared.SimpleStack
import shared.SimpleStack.BLOCK
import shared.SimpleStack.MAX_BLOCK

// JVM-visible wrapper
fun getSimpleStack(): SimpleStack<Any> = getSimpleStackInline()

inline fun <reified E> getSimpleStackInline(): SimpleStack<E> {
    return object : SimpleStack<E> {
        var top = -1
        var stack: Array<E?> = Array(BLOCK) { null }

        override fun push(item: E) {
            if (top + 1 >= MAX_BLOCK) throw IllegalStateException()

            if (top + 1 >= stack.size) {
                val newLen = kotlin.math.min(stack.size + BLOCK, MAX_BLOCK)
                stack = stack.copyOf(newLen)
            }

            stack[++top] = item
        }

        override fun pop(): E {
            if (top < 0) throw NoSuchElementException()
            val item = stack[top] ?: throw NoSuchElementException()
            stack[top] = null
            top--
            return item
        }

        override fun peek(): E {
            if (top < 0) throw NoSuchElementException()
            return stack[top]!!
        }

        override fun isEmpty(): Boolean = top < 0
    }
}