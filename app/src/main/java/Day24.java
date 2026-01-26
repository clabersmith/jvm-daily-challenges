import shared.Graph;
import java.util.*;

public class Day24 {
    public static <T> List<T> doDepthFirstSearch(T start, Graph<T> graph) {
        //set of visited vertex in the order they were found
        Set<T> visited = new LinkedHashSet<>();  //maintains order

        usingRecursion(start, graph, visited);

        //usingIteration(start, graph, visited);

        return new ArrayList<>(visited);
    }

    private static <T> void usingRecursion(T start, Graph<T> graph, Set<T> visited) {
        //process the node if we haven't already
        if (visited.add(start)) {
            List<T> adjacentList = graph.getAdjList(start);
            for (T adj : adjacentList) {
                //continue down the stack if we haven't seen this neighbor before
                if (!visited.contains(adj)) {
                    usingRecursion(adj, graph, visited);
                }
            }
        }
    }

    private static <T> void usingIteration(T start, Graph<T> graph, Set<T> visited) {
        Deque<T> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            T node = stack.pop();
            if (!visited.add(node)) {
                continue;
            }

            List<T> adj = graph.getAdjList(node);
            if (!adj.isEmpty()) {
                // push in reverse to preserve adjacency order
                for (int i = adj.size() - 1; i >= 0; i--) {
                    stack.push(adj.get(i));
                }
            }
        }
    }


}
