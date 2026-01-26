import shared.Graph

fun <T> doDepthFirstSearch(start: T, graph: Graph<T>): List<T> {
    val visited = linkedSetOf<T>()

    //local function for recursion
    fun visit(node: T) {
        if (visited.add(node)) {
            for (adj in graph.getAdjList(node)) {
                visit(adj)
            }
        }
    }

    visit(start)

    return visited.toList()
}