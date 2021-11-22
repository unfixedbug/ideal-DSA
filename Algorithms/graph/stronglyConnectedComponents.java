
//
// Kosarajus Algorithm (dfs)
// Tarjans Algorithm (Arrival , departure time)

import java.util.*;

/* strongly connnected components with DFS, the graph is connected or not */
/*
 * A simplw solution to perform DFS or BFS starting from every vertex in the
 * graph, if each dfs, bfs call visites every another vertex in the graph, then
 * the graph is strongly conected
 */

class SCCDFS {

    /*

    T(n) = O(V+E)
     * 1) start dfs, if any node is unvisited, return false;
     *  2) reverse the Graph 
     * 3)start dfs again, if any node is unvisited, return false;
     *  4) return true
     */
    private static void DFS(Graph graph, int v, boolean[] visited) {
        visited[v] = true;
        for (int u : graph.adjList.get(v)) {
            if (!visited[u]) {
                DFS(graph, u, visited);

            }
        }
    }

    public static boolean isStronglyConnected(Graph graph, int n) {
        boolean visited[] = new boolean[n];
        int v = 0;
        DFS(graph, v, visited);

        // if the dfs traversal does not visit all the edges then the graph is not
        // strongly connected
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }

        // reset visited array
        Arrays.fill(visited, false);

        // reverse the graph
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j : graph.adjList.get(i)) {
                edges.add(new Edge(j, i));
            }
        }
        // create a graph from reversed edges
        Graph gr = new Graph(edges, n);
        // run dfs starting at v
        DFS(graph, v, visited);

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        // if graph passes both DFS, it is Strongly connected
        return true;
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(0, 4), new Edge(1, 0), new Edge(1, 2), new Edge(2, 1), new Edge(2, 4),
                new Edge(3, 1), new Edge(3, 2), new Edge(4, 3));

        // total number of nodes in the graph
        int n = 5;

        // construct graph
        Graph graph = new Graph(edges, n);

        // check if the graph is not strongly connected or not
        if (isStronglyConnected(graph, n)) {
            System.out.println("The graph is strongly connected");
        } else {
            System.out.println("The graph is not strongly connected");
        }
    }
}

class Edge {
    int source, dest;

    Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
}

// class Graph {
//     List<List<Integer>> adjList = null;

//     Graph(List<Edge> edges, int n) {
//         for (int i = 0; i < n; i++) {
//             adjList.add(new ArrayList<>());
//         }
//         // add Edges to directed Graph
//         for (Edge edge : edges) {
//             adjList.get(edge.source).add(edge.dest);
//         }
//     }
// }