
import java.lang.reflect.Array;
import java.util.*;

public class bfsAdjacancyList {
    public static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    private int n;
    private Integer[] prev;// bfs path to be stored in. IE previous element of the element
    private ArrayList<ArrayList<Edge>> graph;

    public bfsAdjacancyList(ArrayList<ArrayList<Edge>> graph) {
        if (graph == null)
            throw new IllegalArgumentException("Graph cannot be null");
        this.graph = graph;
        this.n = graph.size();
    }

    /**
     * Reconstructs the path (of nodes) from 'start' to 'end' inclusive. If the
     * edges are unweighted then this method returns the shortest path from 'start'
     * to 'end'
     *
     * @return An array of nodes indexes of the shortest path from 'start' to 'end'.
     *         If 'start' and 'end' are not connected then an empty array is
     *         returned.
     */

    public List<Integer> reconstructPath(int start, int end) {
        bfs(start);
        List<Integer> path = new ArrayList<>();
        for (Integer at = end; at != null; at = prev[at]) { // path from last to first, then reverse the path
            path.add(at);
        }
        Collections.reverse(path);
        if (path.get(0) == start)
            return path; // correct path as first element is the start element;
        path.clear();
        return path; // else returning the empty path
    }

    private void bfs(int start) {
        prev = new Integer[n];
        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>(n);

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int at = queue.poll();
            for (Edge edge : graph.get(at)) {
                if (!visited[edge.to]) {
                    visited[edge.to] = true;
                    prev[edge.to] = at;
                    queue.offer(edge.to);
                }
            }
        }
    }

    public static ArrayList<ArrayList<Edge>> createEmptyGraph(int n) {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        return graph;
    }

    // for directed Edge put value of cost as it is, but for undirected Edge, set
    // cost to 1;

    // Add a directed edge from node 'u' to node 'v' with cost 'cost'.
    private static void addDirectedEdge(ArrayList<ArrayList<Edge>> graph, int from, int to, int cost) {
        graph.get(from).add(new Edge(from, to, cost));
    }

    // Add an undirected edge between nodes 'u' and 'v'.
    private static void addUnDirectedEdge(ArrayList<ArrayList<Edge>> graph, int from, int to, int cost) {
        addDirectedEdge(graph, from, to, cost);
        addDirectedEdge(graph, to, from, cost);
        // or
    }

    // adding undirected unweighted edge between nodes 'u' and 'v', the directed
    // edge will have cost or weihgt 1;
    private static void addUnweightedUndirectedEdge(ArrayList<ArrayList<Edge>> graph, int from, int to) {
        addUnDirectedEdge(graph, from, to, 1);
    }

    // driver code

    public static void main(String[] args) {
        // BFS example #1 from slides.
        final int n = 13;
        ArrayList<ArrayList<Edge>> graph = createEmptyGraph(n);

        addUnweightedUndirectedEdge(graph, 0, 7);
        addUnweightedUndirectedEdge(graph, 0, 9);
        addUnweightedUndirectedEdge(graph, 0, 11);
        addUnweightedUndirectedEdge(graph, 7, 11);
        addUnweightedUndirectedEdge(graph, 7, 6);
        addUnweightedUndirectedEdge(graph, 7, 3);
        addUnweightedUndirectedEdge(graph, 6, 5);
        addUnweightedUndirectedEdge(graph, 3, 4);
        addUnweightedUndirectedEdge(graph, 2, 3);
        addUnweightedUndirectedEdge(graph, 2, 12);
        addUnweightedUndirectedEdge(graph, 12, 8);
        addUnweightedUndirectedEdge(graph, 8, 1);
        addUnweightedUndirectedEdge(graph, 1, 10);
        addUnweightedUndirectedEdge(graph, 10, 9);
        addUnweightedUndirectedEdge(graph, 9, 8);

        bfsAdjacancyList solver = new bfsAdjacancyList(graph);

        int start = 10, end = 5;
        List<Integer> path = solver.reconstructPath(start, end);
        System.out.printf("The shortest path from %d to %d is: [%s]\n", start, end, formatPath(path));
        // Prints:
        // The shortest path from 10 to 5 is: [10 -> 9 -> 0 -> 7 -> 6 -> 5]

    }

    private static String formatPath(List<Integer> path) {
        return String.join(" -> ", path.stream().map(Object::toString).collect(java.util.stream.Collectors.toList()));
    }

}

class striversbfs {
    public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>(); // traveral will be stored in this
        boolean visited[] = new boolean[v + 1]; // 1 based indexing
        for (int i = 1; i <= v; i++) {
            if (visited[i] == false) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    Integer node = queue.poll();
                    bfs.add(node); // added the node in traversal

                    // traversing all nodes of the node
                    for (Integer at : adj.get(node)) {
                        if (visited[at] == false) {
                            queue.add(at);
                            visited[at] = true;
                        }
                    }
                }

            }
        }
        return bfs;
    }
}