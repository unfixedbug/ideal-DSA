import java.lang.reflect.Array;
import java.util.*;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;;

public class dfsAdjacencylist {
    static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    // map used for unique points maybe
    static int dfs(Map<Integer, ArrayList<Edge>> graph, int start, int n) {
        int count = 0;
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited[start] = true;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            count++;
            // do for every edge
            ArrayList<Edge> edges = graph.get(node);
            if (edges != null) {
                for (Edge edge : edges) {
                    if (!visited[edge.to]) {
                        stack.push(edge.to);
                        visited[edge.to] = true;
                    }
                }
            }
        }

        return count;

    }

    private static void addDirectedEdge(Map<Integer, ArrayList<Edge>> graph, int from, int to, int cost) {
        ArrayList<Edge> list = graph.get(from);
        if (list == null) {
            list = new ArrayList<>();
            graph.put(from, list);
        }
        list.add(new Edge(from, to, cost));
    }

    public static void main(String[] args) {

        int numNodes = 5;
        Map<Integer, ArrayList<Edge>> graph = new HashMap<>();
        addDirectedEdge(graph, 0, 1, 4);
        addDirectedEdge(graph, 0, 2, 5);
        addDirectedEdge(graph, 1, 2, -2);
        addDirectedEdge(graph, 1, 3, 6);
        addDirectedEdge(graph, 2, 3, 1);
        addDirectedEdge(graph, 2, 2, 10); // Self loop

        long nodeCount = dfs(graph, 0, numNodes);
        System.out.println("DFS node count starting at node 0: " + nodeCount);
        if (nodeCount != 4)
            System.err.println("Error with DFS");

        nodeCount = dfs(graph, 4, numNodes);
        System.out.println("DFS node count starting at node 4: " + nodeCount);
        if (nodeCount != 1)
            System.err.println("Error with DFS");
    }
}

class Striversdfs {
    public void dfs(int node, boolean visited[], ArrayList<Integer> storedfs, ArrayList<ArrayList<Integer>> graph) {
        storedfs.add(node);
        visited[node] = true;
        for (Integer at : graph.get(node)) {
            dfs(at, visited, storedfs, graph);
        }
    }

    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> graph) {
        ArrayList<Integer> storedfs = new ArrayList<>();
        boolean[] visited = new boolean[v + 1];
        for (int i = 1; i <= v; i++) {
            if (visited[i] == false) {
                dfs(i, visited, storedfs, graph);
            }
        }
        return storedfs;
    }
}