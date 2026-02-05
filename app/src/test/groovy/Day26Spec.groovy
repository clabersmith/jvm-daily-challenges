import spock.lang.Shared
import spock.lang.Specification

/**
 * Problem:
 * Implement a queue using two stacks.
 *
 * Description:
 * Create a queue data structure that provides standard FIFO (First-In, First-Out)
 * behavior, but implement it internally using only two stack instances.
 *
 * The queue must support the typical operations:
 * - enqueue: add an element to the end of the queue
 * - dequeue: remove and return the element at the front of the queue
 * - peek/front: return the front element without removing it
 *
 * - isEmpty: determine whether the queue contains any elements
 *
 * You may use any existing stack implementation, but you must not use a built-in
 * queue, deque, or linked list to manage ordering.
 *
 * Input:
 * - A sequence of queue operations (enqueue, dequeue, peek, isEmpty).
 * - Values to be inserted into the queue.
 *
 * Output:
 * - Results of operations that return values (dequeue, peek, isEmpty).
 *
 * Constraints:
 * - The queue must preserve correct FIFO ordering at all times.
 * - Dequeue and peek on an empty queue should be handled gracefully
 *   (e.g., by throwing an exception or returning null).
 *
 * Example:
 * Operations:
 *   enqueue(1)
 *   enqueue(2)
 *   enqueue(3)
 *   peek()
 *   dequeue()
 *   dequeue()
 *   enqueue(4)
 *   dequeue()
 *
 * Output:
 *   peek()    -> 1
 *   dequeue() -> 1
 *   dequeue() -> 2
 *   dequeue() -> 3
 */
class Day26Spec extends Specification {

    @Shared
    def factories = [
            [factory: { -> Day26.getSimpleQueue() }, name: 'java'],
            [factory: { -> Day26Kt.getSimpleQueue() }, name: 'kotlin'],
            [factory: { -> Day26Groovy.getSimpleQueue() }, name: 'groovy']
    ]

    def "#factoryRow.name: queue basic enqueue/dequeue and isEmpty behavior"() {
        given:
        def queue = factoryRow.factory()

        when:
        queue.enqueue(10)
        queue.enqueue(20)

        then:
        queue.peek() == 10
        queue.dequeue() == 10
        queue.dequeue() == 20
        queue.isEmpty()

        where:
        factoryRow << factories
    }

    def "#factoryRow.name: queue peek does not remove"() {
        given:
        def queue = factoryRow.factory()

        when:
        queue.enqueue('a')

        then:
        queue.peek() == 'a'
        queue.peek() == 'a'
        !queue.isEmpty()
        queue.dequeue() == 'a'

        where:
        factoryRow << factories
    }

    def "#factoryRow.name: queue mixed operations preserve FIFO"() {
        given:
        def queue = factoryRow.factory()

        when:
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)

        then:
        queue.dequeue() == 1

        when:
        queue.enqueue(4)

        then:
        queue.dequeue() == 2
        queue.dequeue() == 3
        queue.dequeue() == 4
        queue.isEmpty()

        where:
        factoryRow << factories
    }

    def "#factoryRow.name: dequeue and peek on empty throw NoSuchElementException"() {
        given:
        def queue = factoryRow.factory()

        when:
        queue.dequeue()

        then:
        thrown(NoSuchElementException)

        when:
        queue.peek()

        then:
        thrown(NoSuchElementException)

        where:
        factoryRow << factories
    }

}
