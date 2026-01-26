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
        //could just call the static methods directly via GraphHelper but illustrates one of the uses of Groovy's
        //meta programming features
        GraphHelper.addStaticBuilders()
    }

    def "java: perform breadth-wide search of graph"() {
        given:
        def graph = Graph.buildGraphOfStringsWithNoise(adjacents) as Graph<String>

        expect:
        Day23.doBreadthFirstSearch(vertex, graph) == expected

        where:

        vertex      | adjacents                                                                                                         | expected
        'A'         | ['A': ['B', 'C'], 'B': [], 'C': [], 'X': ['Z'], 'Z': []]                                                          | ['A', 'B', 'C']
        'B'         | ['B': [], 'A': ['C'], 'C': ['D'], 'D': []]                                                                        | ['B']
        'C'         | ['C': ['D'], 'D': [], 'E': ['F'], 'F': []]                                                                        | ['C', 'D']
        'D'         | ['D': ['E', 'F'], 'E': [], 'F': ['G'], 'G': [], 'Orphan': ['X']]                                                  | ['D', 'E', 'F', 'G']
        'E'         | ['E': ['H', 'I', 'J',], 'H': [], 'I': [], 'J': ['K', 'L'], 'K': [], 'L': [], 'Noise': []]                         | ['E', 'H', 'I', 'J', 'K', 'L']
        'F'         | ['F': ['G', 'H', 'I', 'J', 'K', 'L', 'M'], 'G': [], 'H': [], 'I': [], 'J': [], 'K': [], 'L': [], 'M': []]         | ['F', 'G', 'H', 'I', 'J', 'K', 'L', 'M']
        'LongStart' | ['LongStart': ['N', 'O', 'P', 'Q', 'R'], 'N': [], 'O': [], 'P': [], 'Q': [], 'R': ['S'], 'S': ['T', 'U'], 'T': [], 'U': [], 'Extra': ['X']]
                                                                                                                                        | ['LongStart', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U']
    }

    def "kotlin: perform breadth-wide search of graph"() {
        given:
        def graph = Graph.buildGraphOfStringsWithNoise(adjacents) as Graph<String>

        expect:
        Day23Kt.doBreadthFirstSearch(vertex, graph) == expected

        where:
        vertex      | adjacents                                                                                                          | expected
        'X'         | ['X': ['Y', 'Z'], 'Y': [], 'Z': ['W']]                                                                             | ['X', 'Y', 'Z', 'W']
        'Y'         | ['Y': []]                                                                                                          | ['Y']
        'Z'         | ['Z': ['W'], 'W': []]                                                                                              | ['Z', 'W']
        'LongX'     | ['LongX': ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'], 'A': [], 'B': [], 'C': [], 'D': [], 'E': [], 'F': [], 'G': [], 'H': [], 'I': [], 'J': []]
                                                                                                                                         | ['LongX', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J']
        'StarNode'  | ['StarNode': ['N1','N2','N3','N4','N5','N6','N7','N8','N9','N10','N11'], 'N1': [], 'N2': [], 'N3': [], 'N4': [], 'N5': [], 'N6': [], 'N7': [], 'N8': [], 'N9': [], 'N10': [], 'N11': []]
                                                                                                                                         | ['StarNode', 'N1', 'N2', 'N3', 'N4', 'N5', 'N6', 'N7', 'N8', 'N9', 'N10', 'N11']
        'WideStart' | ['WideStart': ['N1','N2','N3','N4','N5','N6','N7','N8','N9','N10','N11','N12','N13','N14','N15','N16','N17','N18','N19','N20'], 'N1': [], 'N2': [], 'N3': [], 'N4': [], 'N5': [],
                       'N6': [], 'N7': [], 'N8': [], 'N9': [], 'N10': [], 'N11': [], 'N12': [], 'N13': [], 'N14': [], 'N15': [], 'N16': [], 'N17': [], 'N18': [], 'N19': [], 'N20': []]
                                                                                                                                        | ['WideStart', 'N1', 'N2', 'N3', 'N4', 'N5', 'N6', 'N7', 'N8', 'N9', 'N10', 'N11', 'N12', 'N13', 'N14', 'N15', 'N16', 'N17', 'N18', 'N19', 'N20']
    }

    def "groovy: perform breadth-wide search of graph"() {
        given:
        def graph = Graph.buildGraphOfStringsWithNoise(adjacents) as Graph<String>

        expect:
        Day23Groovy.doBreadthFirstSearch(vertex, graph) == expected

        where:
        vertex      | adjacents                                                                                                         | expected
        'Begin'     | ['Begin': ['Alpha', 'Beta', 'Gamma'], 'Alpha': [], 'Beta': [], 'Gamma': []]                                       | ['Begin', 'Alpha', 'Beta', 'Gamma']
        'Alpha'     | ['Alpha': ['Delta', 'Epsilon'], 'Delta': [], 'Epsilon': []]                                                       | ['Alpha', 'Delta', 'Epsilon']
        'Solo'      | ['Solo': []]                                                                                                      | ['Solo']
        'HubNode'   | ['HubNode': ['N1', 'N2', 'N3', 'N4', 'N5', 'N6', 'N7', 'N8', 'N9', 'N10', 'N11', 'N12'], 'N1': [], 'N2': [], 'N3': [], 'N4': [], 'N5': [], 'N6': [], 'N7': [], 'N8': [], 'N9': [], 'N10': [], 'N11': [], 'N12': []]
                                                                                                                                        | ['HubNode', 'N1', 'N2', 'N3', 'N4', 'N5', 'N6', 'N7', 'N8', 'N9', 'N10', 'N11', 'N12']
        'WideStart' | ['WideStart': ['A1','A2','A3','A4','A5','A6','A7','A8','A9','A10','A11','A12','A13','A14','A15'], 'A1': [], 'A2': [], 'A3': [], 'A4': [], 'A5': [], 'A6': [], 'A7': [], 'A8': [], 'A9': [], 'A10': [], 'A11': [], 'A12': [], 'A13': [], 'A14': [], 'A15': []]
                                                                                                                                        | ['WideStart','A1','A2','A3','A4','A5','A6','A7','A8','A9','A10','A11','A12','A13','A14','A15']
    }

}
