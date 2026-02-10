import spock.lang.Shared
import spock.lang.Specification
import support.ListNodeHelper

/**
 * Problem:
 * Detect a cycle in a linked list.
 *
 * Description:
 * Implement a function that determines whether a singly linked list contains a cycle.
 * A cycle exists if a node's `next` pointer points to a previous node in the list,
 * forming a loop. The function should return `true` if a cycle is present and `false`
 * otherwise.
 *
 * Input:
 * - The head node of a singly linked list.
 *
 * Output:
 * - A boolean indicating whether the linked list contains a cycle.
 *
 * Constraints:
 * - The linked list may be empty.
 * - The solution should aim for O(n) time and O(1) space if possible.
 * - Do not modify the nodes of the list.
 *
 * Example:
 * Input:
 *   1 -> 2 -> 3 -> 4 -> 2 (cycle back to node with value 2)
 * Output:
 *   true
 *
 * Input:
 *   1 -> 2 -> 3 -> 4 -> null
 * Output:
 *   false
 *
 * Notes:
 * - This challenge focuses on pointer manipulation, linked list traversal,
 *   and cycle detection algorithms (e.g., Floyd’s Tortoise and Hare).
 */
class Day27Spec extends Specification {

    def setupSpec() {
        ListNodeHelper.addStaticBuilders()
    }

    @Shared
    def factories = [
        [factory: { listNode -> Day27.hasCycle(listNode) }, name: 'java'],
        [factory: { listNode -> Day27Kt.hasCycle(listNode) }, name: 'kotlin'],
        [factory: { listNode -> Day27Groovy.hasCycle(listNode) }, name: 'groovy']
    ]

    def "#factoryRow.name: detects no cycle for acyclic list"() {
            given:
            def head = ListNodeHelper.buildNonCyclic(10)

            when:
            boolean hasCycle = factoryRow.factory(head)

            then:
            !hasCycle

            where:
            factoryRow << factories
    }

    def "#factoryRow.name: detects cycle for cyclic list"() {
        given:
        def head = ListNodeHelper.buildCyclic(10, 3)

        when:
        boolean hasCycle = factoryRow.factory(head)

        then:
        hasCycle

        where:
        factoryRow << factories
    }

    //this would be useful only as a rough smoke test, would pick up a major memory issue
    //but not prove O(1) space usage
    def "#factoryRow.name: detect O(n) space usage"() {
        given:
        int nodes = 200_000
        def head = ListNodeHelper.buildNonCyclic(nodes)

        when: "acyclic list"
        System.gc()
        Thread.sleep(100)
        long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
        boolean resAcyclic = factoryRow.factory(head)
        System.gc()
        Thread.sleep(100)
        long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()

        then:
        !resAcyclic
        (after - before) < 50_000_000  // allow a 50MB buffer; O(n) extra allocations will typically exceed this

        when: "cyclic list"
        def headCyclic = ListNodeHelper.buildCyclic(nodes, nodes.intdiv(2))
        System.gc()
        Thread.sleep(100)
        long before2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
        boolean resCyclic = factoryRow.factory(headCyclic)
        System.gc()
        Thread.sleep(100)
        long after2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()

        then:
        resCyclic
        (after2 - before2) < 50_000_000

        where:
        factoryRow << factories
    }

}
