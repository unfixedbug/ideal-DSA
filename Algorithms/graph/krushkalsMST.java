import java.util.*;
import java.lang.*;
import java.io.*;

// finding the minimum spanning tree of an (Undirected,weighted,connected  graph)
public class krushkalsMST {

    // int v=4,e=5;
    // Graph graph= new Graph(v,e);
    // graph.edges[0].src=0;

}

class Graph {
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

    Graph(int v, int e) {
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
        Graph graph = new Graph(V, E);

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
