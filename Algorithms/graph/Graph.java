package Algorithms.graph;
import java.util.*;
public class Graph {
    // edge with source and dest
    class Edge {
        int source, dest;

        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    class Graph {

        List<List<Integer>> adjList = null;

        // constructor
        Graph(List<Edge> edges, int n) {
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }

            // add Edges to directed Graph
            for (Edge edge : edges) {
                adjList.get(edge.source).add(edge.dest);
            }
        }
    }

    // edge with source, dest, cost i.e with edge weights
    class Edge1 {
        int source, dest, cost;

        public Edge1(int source, int dest, int cost) {
            this.source = source;
            this.dest = dest;
            this.cost = cost;
        }
    }

    class Graph1 {
        List<List<Edge1>> adjList = null;

        Graph1(List<Edge1> edges, int n) {
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }

            // add Edges to directed Graph
            for (Edge1 edge : edges) {
                adjList.get(edge.source).add(edge);
            }
        }
    }
}