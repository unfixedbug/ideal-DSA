package Extras;

import java.util.*;

class Edge {
    int src, dest;

    public Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

// Node to store vertex, and its parent
class Node {
    int v, parent;

    Node(int v, int parent) {
        this.v = v;
        this.parent = parent;
    }
}

class Graph {
    List<List<Integer>> adjList = null;

    // cosntructer fir the graph class
    Graph(List<Edge> edges, int n) {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        // add edges to the undirected graph
        for (Edge edge : edges) {
            adjList.get(edge.src).add(edge.dest);
            adjList.get(edge.dest).add(edge.src);
        }
    }
}

class cycleDetectionInUnirectedGraphBFS {
    public static boolean BFS(Graph graph, int src, int n) {
        boolean visited[] = new boolean[n];
        visited[src] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(src, -1));// parent of first Node is -1
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int child : graph.adjList.get(node.v)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(new Node(child, node.v));
                } else if (child != node.parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(0, 2), new Edge(0, 3), new Edge(1, 4), new Edge(1, 5),
                new Edge(4, 8), new Edge(4, 9), new Edge(3, 6), new Edge(3, 7), new Edge(6, 10), new Edge(6, 11),
                new Edge(5, 9)
        // edge (5, 9) introduces a cycle in the graph
        );
        int n = 12;
        Graph graph = new Graph(edges, n);
        System.out.println(BFS(graph, 0, n));
    }

}

// using DFS
class cycleDetectionInUnirectedGraphDFS {

    // recursion BKL
    // return tree if cycle is present else false
    public static boolean DFS(Graph graph, int v, boolean[] visited, int parent) {
        visited[v] = true;
        for (int child : graph.adjList.get(v)) {
            if (!visited[child]) {
                if (DFS(graph, child, visited, v)) {
                    return true;
                }
            } else if (child != parent) {
                return true;
            }
        }
        return false;

    }

    // driver Code
    public static void main(String[] args) {
        // List of graph edges
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(0, 6), new Edge(0, 7), new Edge(1, 2), new Edge(1, 5),
                new Edge(2, 3), new Edge(2, 4), new Edge(7, 8), new Edge(7, 11), new Edge(8, 9), new Edge(8, 10),
                new Edge(10, 11)
        // edge (10, 11) introduces a cycle in the graph
        );

        // total number of nodes in the graph (0 to 11)
        int n = 12;

        // build a graph from the given edges
        Graph graph = new Graph(edges, n);

        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[n];

        // Perform DFS traversal from the first vertex
        System.out.println(DFS(graph, 0, discovered, -1));
}