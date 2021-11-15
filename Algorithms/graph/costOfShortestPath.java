
//BELLMAN FORD (SSSP) single source shortest path algorithm
// src --> any vertex
// detect negative cycle
import java.util.*;

class Edge {
    int src, dest, cost;

    public Edge(int src, int dest, int cost) {
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }
}

class Graph {
    List<List<Edge>> adjList = null;

    Graph(List<Edge> edges, int n) {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (Edge e : edges) {
            adjList.get(e.src).add(e);// list originating from the source has properties edge(src,dest,cost)
        }

    }
}

public class costOfShortestPath {
    // perform dfs on the graph and set the departure time of each node
    private static int DFS(Graph graph, int v, boolean[] visited, int[] departure, int time) {
        visited[v] = true;
        for (Edge edge : graph.adjList.get(v)) { // all nodes whose start(source) node is v
            int u = edge.dest;
            if (!visited[u]) {
                time = DFS(graph, u, visited, departure, time);
            }
        }
        // backtrack
        departure[time] = v;
        time++;
        return time;
    }

    // the funtion performs the toplogical sort on DAG and finds longest distance of
    // all vertices, from a given source

    private static void findShortestDistance(Graph graph, int src, int n) {
        // stores vertex number using the departure time as an index
        // ie which vertex was visited first bro
        int departure[] = new int[n];
        Arrays.fill(departure, -1);

        boolean visited[] = new boolean[n];
        int time = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                time = DFS(graph, i, visited, departure, time); // dfs traversal on the I'th Node

            }

        }
        // now we have the departure time of all the nodes
        // we can find the shortest distance from the source to all nodes

        int cost[] = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        // process the vertices int topological order,in order of their decreasing
        // departure time
        for (int i = n - 1; i >= 0; i--) {
            int v = departure[i]; // process the last element first
            // and relax the cost of its adjacent edges
            for (Edge edge : graph.adjList.get(v)) {
                int u = edge.dest; // edge from v -> u
                int w = edge.cost; // weight of the edge

                
                // int w = edge.cost * -1;

                /*
                 * to find cost of the longest path just use this line
                 */

                // if the cost of u is greater, update the cost of u to lower
                if (cost[v] != Integer.MAX_VALUE && cost[v] + w < cost[u]) {
                    cost[u] = cost[v] + w;
                }
            }
        }
        // print the shortest path from the source to all other nodes
        for (int i = 0; i < n; i++) {
            System.out.printf("dist(%d, %d) = %2d\n", src, i, cost[i]);
        }
    }

    /// main function driver code
    public static void main(String[] args) {
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(new Edge(0, 6, 2), new Edge(1, 2, -4), new Edge(1, 4, 1), new Edge(1, 6, 8),
                new Edge(3, 0, 3), new Edge(3, 4, 5), new Edge(5, 1, 2), new Edge(7, 0, 6), new Edge(7, 1, -1),
                new Edge(7, 3, 4), new Edge(7, 5, -4));

        // total number of nodes in the graph (labelled from 0 to 7)
        int n = 8;

        // build a graph from the given edges
        Graph graph = new Graph(edges, n);

        // source vertex
        int source = 7;

        // find the shortest distance of all vertices from the given source
        findShortestDistance(graph, source, n);
    }
}
