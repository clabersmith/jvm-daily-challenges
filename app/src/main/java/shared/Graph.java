package shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {

    private Map<T, List<T>> adjMap = new HashMap<>();

    public void addVertex(T vertex) {
        adjMap.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(T source, T destination) {
        //add vertices to graph if they don't exist
        addVertex(source);
        addVertex(destination);

        adjMap.get(source).add(destination);
    }

    public List<T> getAdjList(T source) {
        return adjMap.getOrDefault(source, new ArrayList<>());
    }

}
