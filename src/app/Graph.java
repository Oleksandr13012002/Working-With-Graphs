package app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

    private final Map<Integer, Set<Integer>> adjacencyList;
    private final boolean isDirected;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
        adjacencyList = new HashMap<>();
    }

    public boolean IsDirected(){
        return isDirected;
    }

    public void addVertex(int vertex){
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    public void addEdge(int source, int destination){
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
        if (!isDirected) {
            adjacencyList.get(destination).add(source);
        }
    }

    public void addEdge(Edge edge){
        addEdge(edge.getSource(), edge.getDestination());
    }

    public void removeVertex(int vertex){
        if (!adjacencyList.containsKey(vertex))
            return;

        for (int neighbor : adjacencyList.get(vertex)) {
            adjacencyList.get(neighbor).remove(vertex);
        }
        adjacencyList.remove(vertex);

        if (isDirected) {
            for (Set<Integer> neighbors : adjacencyList.values()) {
                neighbors.remove(vertex);
            }
        }
    }

    public void removeEdge(int source, int destination){
        if (adjacencyList.containsKey(source)) {
            adjacencyList.get(source).remove(destination);
        }
        if (!isDirected && adjacencyList.containsKey(destination)) {
            adjacencyList.get(destination).remove(source);
        }
    }

    public void removeEdge(Edge edge){
        removeEdge(edge.getSource(), edge.getDestination());
    }

    public boolean hasVertex(int vertex){
        return adjacencyList.containsKey(vertex);
    }

    public boolean hasEdge(int source, int destination){
        return adjacencyList.containsKey(source) &&
                adjacencyList.get(source).contains(destination);
    }

    public boolean hasEdge(Edge edge){
        return hasEdge(edge.getSource(), edge.getDestination());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isDirected ? "Directed" : "Undirected").append(" Graph:\n");
        for (Map.Entry<Integer, Set<Integer>> entry : adjacencyList.entrySet()) {
            sb.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
