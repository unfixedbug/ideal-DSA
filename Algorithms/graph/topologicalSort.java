
/*
two methods for TOP SORT

1)
2) KAHNS algo, traverse through nodes with in-degree 0
*/
import java.util.*;

public class topologicalSort {

    static int dfs(Graph graph, int v, boolean[] visited, int[] departure, int time) {
        visited[v] = true;

        // arrival time of vertex v
        time++;
        for (int u : graph.adjList.get(v)) {
            // for every edge v -> U
            if (!visited[u]) {
                time = dfs(graph, u, visited, departure, time);
            }
        }

        // backtracking, departure time of vertex v
        departure[time] = v;
        time++;

        return time;
    }

    public static void doTopSort1(Graph graph, int n) {
        int departure[] = new int[2 * n];
        Arrays.fill(departure, -1);
        int time = 0;
        boolean visited[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                time = dfs(graph, i, visited, departure, time);
            }
        }
        // print the vertices in order of their decreasing order
        // of their departure time is DFS i.e topological order
        for (int i = 2 * n - 1; i >= 0; i--) {
            if (departure[i] != -1) {
                System.out.println(departure[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(new Edge(0, 6), new Edge(1, 2), new Edge(1, 4), new Edge(1, 6), new Edge(3, 0),
                new Edge(3, 4), new Edge(5, 1), new Edge(7, 0), new Edge(7, 1));

        // total number of nodes in the graph (labelled from 0 to 7)
        int n = 8;

        // build a graph from the given edges
        Graph graph = new Graph(edges, n);

        // perform topological sort
        doTopSort1(graph, n);
    }
}

class Edge {
    int src, dest;

    public Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

class Graph {
    List<List<Integer>> adjList = null;

    // stores the indgeree of the vertex
    List<Integer> indegree = null;

    Graph(List<Edge> edges, int n) {
        adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        indegree = new ArrayList<>(Collections.nCopies(n, 0));
        for (Edge edge : edges) {
            int src = edge.src;
            int dest = edge.dest;

            // source to destinantion
            adjList.get(src).add(dest);
            indegree.set(dest, indegree.get(dest) + 1);
        }
    }
}

class KahnsTopSort {
    // top sort on DAG
    private static List<Integer> doTopSort2(Graph graph, int n) {
        List<Integer> topSort = new ArrayList<>();
        List<Integer> indegree = graph.indegree;
        Stack<Integer> starters = new Stack<>();
        for (int i = 0; i < n; i++) {
            // nodes with no incoming edges are the starting nodes (no prerequisites)
            if (indegree.get(i) == 0) {
                starters.push(i);
            }
        }
        while (!starters.isEmpty()) {
            int node = starters.pop();
            topSort.add(node);

            for (int dest : graph.adjList.get(node)) { // traversing thorugh all outgoing edges from 'node'
                // now removing the edge from 'node' --> dest
                indegree.set(dest, indegree.get(dest) - 1);

                if (indegree.get(dest) == 0) {
                    starters.push(dest);
                }
            }
        }
        // if the graph still has edges, then there is a cycle
        for (int i = 0; i < n; i++) {
            if (indegree.get(i) != 0) {
                return null;
            }
        }

        return topSort;
    }

    public static void main(String[] args) {
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(new Edge(0, 6), new Edge(1, 2), new Edge(1, 4), new Edge(1, 6), new Edge(3, 0),
                new Edge(3, 4), new Edge(5, 1), new Edge(7, 0), new Edge(7, 1));

        // total number of nodes in the graph (labelled from 0 to 7)
        int n = 8;

        // build a graph from the given edges
        Graph graph = new Graph(edges, n);

        // Perform topological sort
        List<Integer> L = doTopSort2(graph, n);

        if (L != null) {
            System.out.print(L); // print topological order
        } else {
            System.out.println("Graph has at least one cycle. " + "Topological sorting is not possible");
        }
    }

}

// dfs topsort

class stackTopSort {
    // recursive
    void topologicalsortUtil(ArrayList<ArrayList<Integer>> adjlist, int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        Integer i;
        Iterator<Integer> it = adjlist.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                topologicalsortUtil(adjlist, i, visited, stack);
            }
        }
        stack.push(v);
    }
    void topologicalSort(){
        Stack<Integer> stack = new Stack<Integer>();
    }
}