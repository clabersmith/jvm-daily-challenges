import spock.lang.Shared
import spock.lang.Specification
import static shared.SimpleStack.*

/**
 * Problem:
 * Implement a simple stack from scratch.
 *
 * Description:
 * Implement a stack data structure without using built-in stack or deque classes.
 * The stack should follow the Last-In, First-Out (LIFO) principle and support basic
 * operations such as push, pop, peek, and checking whether the stack is empty.
 *
 * The implementation may use an underlying array or list for storage, but all stack
 * behavior (resizing, bounds checking, etc.) must be managed explicitly.
 *
 * Input:
 * - A sequence of stack operations (e.g., push, pop, peek).
 * - Values to be pushed onto the stack.
 *
 * Output:
 * - The result of stack operations that return values (e.g., pop, peek).
 * - The final state of the stack if needed for verification.
 *
 * Constraints:
 * - Popping or peeking from an empty stack should be handled gracefully
 *   (e.g., by throwing an exception or returning null).
 * - The stack should grow dynamically if backed by an array.
 * - All operations should run in O(1) time on average.
 *
 * Example:
 * Input (operations):
 *   push(10)
 *   push(20)
 *   peek()
 *   pop()
 *   push(30)
 *   pop()
 *
 * Output:
 *   peek() -> 20
 *   pop()  -> 20
 *   pop()  -> 30
 *
 * Notes:
 * - This challenge focuses on understanding fundamental data structures,
 *   memory management, and encapsulation.
 * - Avoid using built-in Stack, Deque, or similar high-level abstractions.
 */
class Day25Spec extends Specification {

    @Shared
    def factories = [
        [factory: { -> Day25.getSimpleStack() }, name: 'java'],
        [factory: { -> Day25Kt.getSimpleStack() }, name: 'kotlin'],
        [factory: { -> Day25Groovy.getSimpleStack() }, name: 'groovy']
    ]

    def "stack basic push/pop and isEmpty behavior (impl: #factoryRow.name)"() {
        given:
        def stack = factoryRow.factory()

        when:
        stack.push(10)
        stack.push(20)

        then:
        stack.peek() == 20
        stack.pop() == 20
        stack.pop() == 10
        stack.isEmpty()

        where:
        factoryRow << factories
    }

    def "peek does not remove top element (impl: #factoryRow.name)"() {
        given:
        def stack = factoryRow.factory()

        when:
        stack.push("a")
        stack.push("b")
        def top = stack.peek()

        then:
        top == "b"
        !stack.isEmpty()
        stack.pop() == "b"

        where:
        factoryRow << factories
    }

    def "pop and peek on empty stack throw NoSuchElementException (impl: #factoryRow.name)"() {
        given:
        def stack = factoryRow.factory()

        when:
        stack.pop()

        then:
        thrown(NoSuchElementException)

        when:
        stack.peek()

        then:
        thrown(NoSuchElementException)

        where:
        factoryRow << factories
    }

    def "stack grows dynamically when pushing many elements (impl: #factoryRow.name)"() {
        given:
        def stack = factoryRow.factory()
        int count = 200

        when:
        (0..<count).each { stack.push(it) }

        then:
        stack.pop() == count - 1
        stack.pop() == count - 2
        stack.peek() == count - 3

        and:
        (0..5).each {
            if (!stack.isEmpty()) {
                stack.pop()
            }
        }

        where:
        factoryRow << factories
    }

    def "pushing beyond max size throws IllegalStateException (impl: #factoryRow.name)"() {
        given:
        def stack = factoryRow.factory()

        when:
        (0..<MAX_BLOCK).each { stack.push(it) }

        then:
        stack.peek() == MAX_BLOCK - 1

        when:
        stack.push(MAX_BLOCK)

        then:
        thrown(IllegalStateException)

        where:
        factoryRow << factories
    }
}
