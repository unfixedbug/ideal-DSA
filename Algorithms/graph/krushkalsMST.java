import java.util.*;
import java.lang.*;
import java.io.*;

// finding the minimum spanning tree of an (Undirected,weighted,connected  graph)
//williams O(ELog(E))
public class krushkalsMST {
    static class UnionFind {
        private int[] id, sz;

        public UnionFind(int n) {
            id = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        public int find(int p) {
            int root = p;
            while (root != id[root]) {
                root = id[root];
            }
            // do path compression
            while (p != root) {
                int next = id[p];
                id[p] = root;
                p = next;
            }
            return root;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public int size(int p) {
            return sz[find(p)];
        }

        public void union(int p, int q) {
            int root1 = find(p);
            int root2 = find(q);
            if (root1 == root2)
                return;
            if (sz[root1] < sz[root2]) {
                sz[root2] += sz[root1];
                id[root1] = root2;
            } else {
                sz[root1] += sz[root2];
                id[root2] = root1;
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }
    // Given a graph represented as an edge list this method finds
    // the Minimum Spanning Tree (MST) cost if there exists
    // a MST, otherwise it returns null.

    static Long krushkasls(Edge[] edges, int n) {
        if (edges == null)
            return null;
        long sum = 0L;

        java.util.Arrays.sort(edges);
        UnionFind uf = new UnionFind(n);

        for (Edge edge : edges) {
            if (uf.connected(edge.from, edge.to))
                continue;
            // agar dono alag alag hait to
            uf.union(edge.from, edge.to);
            sum += edge.weight;

            // early compeeletion
            if (uf.size(0) == n - 1)
                break;

        }
        if (uf.size(0) != n)
            return null;

        return sum;
    }
}

// traditional
class Graph1 {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        // comparator function used for sortigng edges based on their weight
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    };

    // union find data structure
    class subset {
        int parent, rank;
    };

    int V, E;
    Edge edges[];

    Graph1(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge();
        }
    }

    int find(subset subsets[], int i) {
        // path compresion
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        // union by rank
        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        }
        // if ranks are the same then any one as root and increment its rank by one
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void KrushkalsMST() {
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; i++) {
            result[i] = new Edge();
        }

        // allocate memory for creatin V subsets
        subset subsets[] = new subset[V];
        for (i = 0; i < V; i++) {
            subsets[i] = new subset();
        }
        // crewating v subsets with single elements
        for (int v = 0; v < V; v++) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        // Krushkals algorithm

        // treaversing the edges based on their edgeweights
        Arrays.sort(edges);
        i = 0;
        while (e < V - 1) {
            // Step 2: Pick the smallest edge. And increment
            // the index for next iteration
            Edge next_edge = edges[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            // If including this edge does't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }

        // printing the MST
        int mincost = 0;
        // print the edges in decreasing order of their weights
        System.out.println("Following are the edges in " + "the constructed MST");
        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree " + minimumCost);
    }

    // doing the work of the main funciton
    public static void main(String[] args) {
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        Graph1 graph = new Graph1(V, E);

        // add edge 0-1
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 10;

        // add edge 0-2
        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 6;

        // add edge 0-3
        graph.edges[2].src = 0;
        graph.edges[2].dest = 3;
        graph.edges[2].weight = 5;

        // add edge 1-3
        graph.edges[3].src = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 15;

        // add edge 2-3
        graph.edges[4].src = 2;
        graph.edges[4].dest = 3;
        graph.edges[4].weight = 4;

        // Function call
        graph.KrushkalsMST();
    }
}
