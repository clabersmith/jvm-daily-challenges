import shared.Graph

class Day23Groovy {
    static <T> List<T> doBreadthFirstSearch(T start, Graph<T> graph) {
        def visited = new LinkedHashSet<T>([start])
        def queue = new ArrayDeque<T>([start])

        while (!queue.isEmpty()) {
            def curr = queue.removeFirst()
            graph.getAdjList(curr).each { adj ->
                if (visited.add(adj)) queue.addLast(adj)
            }
        }

        visited as List
    }
}
