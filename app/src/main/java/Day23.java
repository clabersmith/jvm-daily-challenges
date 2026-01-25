import shared.Graph;

import java.util.*;

public class Day23 {
    public static <T> List<T> doBreadthFirstSearch(T start, Graph<T> graph) {
         //set of visited vertex in the order they were found
        Set<T> visited = new LinkedHashSet<>();
        Queue<T> queue = new ArrayDeque<>();
        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            //pull the item from the top of the list
            T currVertex = queue.poll();
            List<T> adjacencyList = graph.getAdjList(currVertex);

            for(T adj : adjacencyList) {
                //if we haven't already visited the vertex, add to both
                if(visited.add(adj)) {
                    queue.add(adj);
                }
            }
        }

        return new ArrayList<>(visited);
    }
}
