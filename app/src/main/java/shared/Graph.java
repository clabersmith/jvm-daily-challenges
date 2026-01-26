package shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple generic directed graph backed by a map from vertices to their
 * adjacency lists. Vertices may be added explicitly via {@link #addVertex(Object)}
 * or implicitly when edges are added with {@link #addEdge(Object, Object)}.
 *
 * @param <T> the vertex type
 */
public class Graph<T> {

    private Map<T, List<T>> adjMap = new HashMap<>();

    /**
     * Adds a vertex to the graph. If the vertex already exists this method has no effect.
     *
     * @param vertex the vertex to add; may be {@code null}
     */
    public void addVertex(T vertex) {
        adjMap.putIfAbsent(vertex, new ArrayList<>());
    }


    /**
     * Adds a directed edge from {@code source} to {@code destination}.
     * If either vertex does not exist in the graph it will be added first.
     *
     * @param source the source vertex (edge start); may be {@code null}
     * @param destination the destination vertex (edge end); may be {@code null}
     */
    public void addEdge(T source, T destination) {
        //add vertices to graph if they don't exist
        addVertex(source);
        addVertex(destination);

        adjMap.get(source).add(destination);
    }

    /**
     * Returns the adjacency list for the given vertex.
     *
     * @param source the vertex whose adjacency list is requested
     * @return a list of adjacent vertices; may be empty if the vertex does not
     *         exist or has no outgoing edges (never returns {@code null})
     */
    public List<T> getAdjList(T source) {
        return adjMap.getOrDefault(source, new ArrayList<>());
    }

}
