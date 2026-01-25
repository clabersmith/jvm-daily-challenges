import shared.Graph
import spock.lang.Specification
import support.GraphHelper

/**
 * Problem:
 * Perform a breadth-first search (BFS) on a graph starting from a given node.
 *
 * Description:
 * Implement a function that traverses a graph using the Breadth-First Search (BFS) algorithm.
 * BFS explores nodes level by level, visiting all immediate neighbors of a node before moving
 * on to their neighbors. The function should return the order in which nodes are visited during
 * the traversal.
 *
 * The graph may be represented using an adjacency list or adjacency map, and it may contain
 * cycles. The implementation must ensure that each node is visited at most once.
 *
 * Input:
 * - A graph represented as an adjacency structure (e.g., Map<T, List<T>>).
 * - A starting node from which to begin the BFS traversal.
 *
 * Output:
 * - A list of nodes representing the order in which nodes were visited during BFS.
 *
 * Constraints:
 * - The graph may be disconnected.
 * - The starting node is guaranteed to exist in the graph.
 * - The graph may contain cycles.
 *
 * Example:
 * Input:
 *   Graph:
 *     A -> [B, C]
 *     B -> [D, E]
 *     C -> [F]
 *     D -> []
 *     E -> []
 *     F -> []
 *   Start: A
 *
 * Output:
 *   [A, B, C, D, E, F]
 *
 * Notes:
 * - This challenge focuses on graph traversal, queue-based processing, and cycle detection.
 * - The implementation should run in O(V + E) time, where V is the number of vertices
 *   and E is the number of edges.
 */
class Day23Spec extends Specification {

    def setupSpec() {
        GraphHelper.addStaticBuilders()
    }

    def "java: perform breadth-wide search of graph"() {
        given:
        def graph = GraphHelper.buildGraphOfStringsWithNoise(vertex, adjacents) as Graph<String>

        expect:
        Day23.doBreadthFirstSearch(vertex, graph) == expected

        where:

        vertex      | adjacents                                 | expected
        'A'         | ['B', 'C']                                | ['A', 'B', 'C']
        'B'         | []                                        | ['B']
        'C'         | ['D']                                     | ['C', 'D']
        'D'         | ['E', 'F', 'G']                           | ['D', 'E', 'F', 'G']
        'E'         | ['H', 'I', 'J', 'K', 'L']                 | ['E', 'H', 'I', 'J', 'K', 'L']
        'F'         | ['G', 'H', 'I', 'J', 'K', 'L', 'M']       | ['F', 'G', 'H', 'I', 'J', 'K', 'L', 'M']
        'LongStart' | ['N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U']  | ['LongStart', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U']
    }

    def "kotlin: perform breadth-wide search of graph"() {
        given:
        def graph = GraphHelper.buildGraphOfStringsWithNoise(vertex, adjacents) as Graph<String>

        expect:
        Day23Kt.doBreadthFirstSearch(vertex, graph) == expected

        where:
        vertex      | adjacents                                 | expected
        'X'         | ['Y', 'Z']                                | ['X', 'Y', 'Z']
        'Y'         | []                                        | ['Y']
        'Z'         | ['W']                                     | ['Z', 'W']
        'LongX'     | ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J']
                                                                | ['LongX', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J']
        'StarNode'  | ['N1', 'N2', 'N3', 'N4', 'N5', 'N6', 'N7', 'N8', 'N9', 'N10', 'N11']
                                                                | ['StarNode', 'N1', 'N2', 'N3', 'N4', 'N5', 'N6', 'N7', 'N8', 'N9', 'N10', 'N11']
        'WideStart' | ['N1', 'N2', 'N3', 'N4', 'N5', 'N6', 'N7', 'N8', 'N9', 'N10', 'N11', 'N12', 'N13', 'N14', 'N15', 'N16', 'N17', 'N18', 'N19', 'N20']
                                                                | ['WideStart', 'N1', 'N2', 'N3', 'N4', 'N5', 'N6', 'N7', 'N8', 'N9', 'N10', 'N11', 'N12', 'N13', 'N14', 'N15', 'N16', 'N17', 'N18', 'N19', 'N20']
    }

    def "groovy: perform breadth-wide search of graph"() {
        given:
        def graph = GraphHelper.buildGraphOfStringsWithNoise(vertex, adjacents) as Graph<String>

        expect:
        Day23Groovy.doBreadthFirstSearch(vertex, graph) == expected

        where:
        vertex      | adjacents                                 | expected
        'Begin'     | ['Alpha', 'Beta', 'Gamma']                | ['Begin', 'Alpha', 'Beta', 'Gamma']
        'Alpha'     | ['Delta', 'Epsilon']                      | ['Alpha', 'Delta', 'Epsilon']
        'Solo'      | []                                        | ['Solo']
        'HubNode'   | ['N1', 'N2', 'N3', 'N4', 'N5', 'N6', 'N7', 'N8', 'N9', 'N10', 'N11', 'N12']
                                                                | ['HubNode', 'N1', 'N2', 'N3', 'N4', 'N5', 'N6', 'N7', 'N8', 'N9', 'N10', 'N11', 'N12']
        'WideStart' | ['A1','A2','A3','A4','A5','A6','A7','A8','A9','A10','A11','A12','A13','A14','A15']
                                                                | ['WideStart','A1','A2','A3','A4','A5','A6','A7','A8','A9','A10','A11','A12','A13','A14','A15']
    }

}
