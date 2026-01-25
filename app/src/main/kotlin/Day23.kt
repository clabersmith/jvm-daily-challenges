import shared.Graph

fun <T> doBreadthFirstSearch(start: T, graph: Graph<T>): List<T> {
    val visited = linkedSetOf<T>().apply { add(start) }
    val queue = ArrayDeque<T>().apply { add(start) }

    while (queue.isNotEmpty()) {
        val curr = queue.removeFirst()
        graph.getAdjList(curr).forEach { adj ->
            if (visited.add(adj)) queue += adj
        }
    }

    return visited.toList()
}