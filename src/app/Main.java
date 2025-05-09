package app;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args){

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(1, 2));
        edges.add(new Edge(1, 3));
        edges.add(new Edge(2, 4));
        edges.add(new Edge(2, 5));
        edges.add(new Edge(3, 4));

        Graph directedGraph = new Graph(true);
        Graph undirectedGraph = new Graph(false);

        fillGraph(directedGraph, edges);
        fillGraph(undirectedGraph, edges);

        System.out.println("Directed graph: has edge 2 -> 1? " + directedGraph.hasEdge(2, 1));
        System.out.println("Directed graph: has edge 1 -> 2? " + directedGraph.hasEdge(1, 2));

        System.out.println("Undirected: has edge 2 -> 1? " + undirectedGraph.hasEdge(2, 1));
        System.out.println("Undirected: has edge 1 -> 2? " + undirectedGraph.hasEdge(1, 2));

        directedGraph.removeEdge(1, 2);
        undirectedGraph.removeEdge(1, 2);

        System.out.println("\nRemoving edge 1 -> 2 from graphs\n");

        System.out.println("Directed graph: has edge 2 -> 1? " + directedGraph.hasEdge(2, 1));
        System.out.println("Directed graph: has edge 1 -> 2? " + directedGraph.hasEdge(1, 2));

        System.out.println("Undirected: has edge 2 -> 1? " + undirectedGraph.hasEdge(2, 1));
        System.out.println("Undirected: has edge 1 -> 2? " + undirectedGraph.hasEdge(1, 2));

        System.out.println();
        System.out.println(directedGraph);
        System.out.println(undirectedGraph);

        directedGraph.removeVertex(5);
        undirectedGraph.removeVertex(5);

        System.out.println("Removing vertex 5 from graphs");

        System.out.println();
        System.out.println(directedGraph);
        System.out.println(undirectedGraph);

    }

    public static void fillGraph(Graph graph, List<Edge> edges){
        for(Edge edge : edges){
            graph.addEdge(edge);
        }
    }
}
