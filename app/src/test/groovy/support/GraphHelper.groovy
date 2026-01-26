package support

import shared.Graph

class GraphHelper {

    /**
     * Install static builder helpers onto the Graph class for tests.
     *
     * This is an example of Groovy's dynamic programming support, as it
     * adds a static method `buildGraphOfStringsWithNoise(Map)` to the `Graph`
     * metaClass that delegates to the local `buildGraphOfStringsWithNoise(...)`
     * helper. This allows tests to call `Graph.buildGraphOfStringsWithNoise(...)`.
     *
     */
    static void addStaticBuilders() {
        Graph.metaClass.static.buildGraphOfStringsWithNoise = { adjacents -> buildGraphOfStringsWithNoise(adjacents) }
    }

     /**
     * Build a Graph\<String\> from the given adjacency map and optionally add random
     * "extra" vertices with edges among them (noise).
     *
     * @param adjacencyMap map of vertex -> list of neighbor vertex names used to
     *        populate the graph
     * @param maxExtra maximum number of extra unrelated vertices to add (0..maxExtra)
     * @param seed optional random seed (0L for non-deterministic)
     * @return a Graph\<String\> containing the provided vertices and any added extras
     */
    static Graph<String> buildGraphOfStringsWithNoise(Map<String, List<String>> adjacencyMap,
               int maxExtra = 3, long seed = 0L) {
        def rnd = (seed > 0) ? new Random(seed) : new Random()
        def graph = new Graph<String>()

        // Populate graph from the given adjacency map
        adjacencyMap.each { String vertex, List<String> neighbors ->
            graph.addVertex(vertex)
            if (neighbors) {
                neighbors.each { neighbor ->
                    // addEdge will ensure both vertices exist
                    graph.addEdge(vertex, neighbor)
                }
            }
        }

        // Decide how many extra unrelated vertices to add (0..maxExtra)
        int extraCount = (maxExtra > 0) ? rnd.nextInt(maxExtra + 1) : 0
        def existing = new HashSet(adjacencyMap.keySet())
        adjacencyMap.values().each { list -> if (list) existing.addAll(list) }

        def extras = (1..extraCount).collect { idx ->
            def name = uniqueExtraName(idx, rnd, existing)
            existing.add(name)
            name
        }

        // Initialize extras in the graph
        extras.each { graph.addVertex(it) }

        // Add edges among extras only (no references to input vertices)
        extras.each { v ->
            int outDeg = rnd.nextInt(3) // 0..2 outgoing edges
            def possible = extras.findAll { it != v }
            def neighbors = (0..<outDeg).collect {
                if (possible) possible[rnd.nextInt(possible.size())] else null
            }.findAll { it }
            neighbors.unique().each { n -> graph.addEdge(v, n) }
        }

        graph
    }

    private static String uniqueExtraName(int idx, Random rnd, Set existing) {
        String name
        do {
            name = "X${idx}_${Math.abs(rnd.nextInt()) % 10000}"
        } while (existing.contains(name))
        name
    }

}