class Day24Groovy {
    static def doDepthFirstSearch(start, graph) {
        def visited = [] as LinkedHashSet

        //closure for recursion
        def visit
        visit = { node ->
            if (visited.add(node)) {
                graph.getAdjList(node).each { visit(it) }
            }
        }

        visit(start)

        visited as List
    }
}
