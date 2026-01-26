import shared.Graph
import spock.lang.Specification
import support.GraphHelper

/**
 * Problem:
 * Perform a depth-first search (DFS) on a graph starting from a given node.
 *
 * Description:
 * Implement a function that traverses a graph using the Depth-First Search (DFS) algorithm.
 * DFS explores as far as possible along each branch before backtracking. The function should
 * return the order in which nodes are visited during the traversal.
 *
 * The graph may be represented using an adjacency list or adjacency map, and it may contain
 * cycles. The implementation must ensure that each node is visited at most once.
 *
 * Input:
 * - A graph represented as an adjacency structure (e.g., Map<T, List<T>>).
 * - A starting node from which to begin the DFS traversal.
 * - Can Assume all nodes will  be non-null and searching a node with no adjencies will return an empty list
 *
 * Output:
 * - A list of nodes representing the order in which nodes were visited during DFS.
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
 * Output (one possible DFS order):
 *   [A, B, D, E, C, F]
 *
 * Notes:
 * - This challenge focuses on graph traversal, recursion or stack-based processing,
 *   and cycle detection.
 * - The implementation should run in O(V + E) time, where V is the number of vertices
 *   and E is the number of edges.
 */
class Day24Spec extends Specification {

    def setupSpec() {
        GraphHelper.addStaticBuilders()
    }

    def "java: perform depth-first search of graph"() {
        given:
        def graph = Graph.buildGraphOfStringsWithNoise(adjacents) as Graph<String>

        expect:
        Day24.doDepthFirstSearch(vertex, graph) == expected

        where:
        vertex      | adjacents                                                                        | expected
        'A'         | ['A': ['B', 'C'], 'B': ['D', 'E'], 'C': ['F'], 'D': [], 'E': [], 'F': []]        | ['A', 'B', 'D', 'E', 'C', 'F']
        'A'         | ['A': ['B', 'C'], 'B': ['A'], 'C': []]                                           | ['A', 'B', 'C']
        'X'         | ['X': ['Y'], 'Y': ['Z'], 'Z': ['X'], 'W': []]                                    | ['X', 'Y', 'Z']
        'L'         | ['L': ['M'], 'M': ['N'], 'N': []]                                                | ['L', 'M', 'N']
        'S'         | ['S': ['A', 'B', 'C'], 'A': [], 'B': [], 'C': []]                                | ['S', 'A', 'B', 'C']
        'K'         | ['K': ['L', 'M'], 'L': ['K', 'M'], 'M': ['K', 'L']]                              | ['K', 'L', 'M']
        'R'         | ['R': ['A', 'B'], 'A': ['C'], 'B': [], 'C': []]                                  | ['R', 'A', 'C', 'B']
        'U'         | ['U': ['V'], 'V': [], 'W': ['X'], 'X': []]                                       | ['U', 'V']
        'D'         | ['D': ['E', 'F'], 'E': ['G'], 'F': ['G'], 'G': []]                               | ['D', 'E', 'G', 'F']
        'P'         | ['P': ['P', 'Q'], 'Q': []]                                                       | ['P', 'Q']
    }

    def "kotlin: perform depth-first search of graph"() {
        given:
        def graph = Graph.buildGraphOfStringsWithNoise(adjacents) as Graph<String>

        expect:
        Day24Kt.doDepthFirstSearch(vertex, graph) == expected

        where:
        vertex      | adjacents                                                                         | expected
        'A'         | ['A': ['B', 'C'], 'B': ['D'], 'C': ['E', 'F'], 'D': [], 'E': [], 'F': []]         | ['A', 'B', 'D', 'C', 'E', 'F']
        'M'         | ['M': ['N', 'O'], 'N': [], 'O': ['P'], 'P': []]                                   | ['M', 'N', 'O', 'P']
        'Q'         | ['Q': ['R'], 'R': ['S'], 'S': ['Q']]                                              | ['Q', 'R', 'S']
        'T'         | ['T': ['U', 'V'], 'U': ['W'], 'V': [], 'W': []]                                   | ['T', 'U', 'W', 'V']
        'Z'         | ['Z': ['Z', 'Y'], 'Y': []]                                                        | ['Z', 'Y']
    }

    def "groovy: perform depth-first search of graph"() {
        given:
        def graph = Graph.buildGraphOfStringsWithNoise(adjacents) as Graph<String>

        expect:
        Day24Groovy.doDepthFirstSearch(vertex, graph) == expected

        where:
        vertex      | adjacents                                                                         | expected
        'S'         | ['S': ['T', 'U'], 'T': ['V'], 'U': [], 'V': []]                                   | ['S', 'T', 'V', 'U']
        'B'         | ['B': ['C', 'D'], 'C': ['E'], 'D': ['E'], 'E': []]                                | ['B', 'C', 'E', 'D']
        'Z'         | ['Z': ['Y'], 'Y': ['X'], 'X': ['Z']]                                              | ['Z', 'Y', 'X']
        'A'         | ['A': []]                                                                         | ['A']
        'P'         | ['P': ['Q', 'R'], 'Q': ['R'], 'R': []]                                            | ['P', 'Q', 'R']
    }
}
