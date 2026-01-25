package support

import shared.Graph

class GraphHelper {

    static void addStaticBuilders() {
        Graph.metaClass.static.buildGraphOfStringsWithNoise = { target, adjacents -> buildGraphOfStringsWithNoise(target, adjacents)}
    }

    /**
     * Build an adjacency map where `target` has the given `adjacents`.
     * Adds up to `maxExtra` unrelated vertices and edges (they won't reference
     * the `target` or its adjacents). If `seed` > 0 a deterministic Random is used.
     *
     * Example:
     *   buildGraphWithNoise('A', ['B','C'], 2, 42)
     */
    static Graph<String> buildGraphOfStringsWithNoise(String target, List<String> adjacents,
            int maxExtra = 3, long seed = 0L) {

        def rnd = (seed > 0) ? new Random(seed) : new Random()
        def graph = new Graph<String>()

        // Add target and its adjacents
        graph.addVertex(target)
        adjacents.each { node ->
            // addEdge will ensure both vertices exist
            graph.addEdge(target, node)
        }

        // Decide how many extra unrelated vertices to add (0..maxExtra)
        int extraCount = (maxExtra > 0) ? rnd.nextInt(maxExtra + 1) : 0
        def existing = new HashSet(adjacents)
        existing.add(target)
        def extras = (1..extraCount).collect { idx ->
            def name = uniqueExtraName(idx, rnd, existing)
            existing.add(name)
            name
        }

        // Initialize extras in the graph
        extras.each { graph.addVertex(it) }

        // Add edges among extras only (no references to target or its adjacents)
        extras.each { v ->
            int outDeg = rnd.nextInt(3) // 0..2 outgoing edges
            def possible = extras.findAll { it != v }
            def neighbors = (0..<outDeg).collect {
                if (possible) possible[rnd.nextInt(possible.size())] else null
            }.findAll { it }
            neighbors.unique().each { n -> graph.addEdge(v, n) }
        }

        // Return the populated Graph object
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