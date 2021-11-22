
import java.util.*;
import java.lang.*;
import java.io.*;

public class primsMST {
    class node1 {
        int dest, weight;

        node1(int a, int b) {
            dest = a;
            weight = b;
        }
    }

    static class Graph {
        int V;
        // list of adjacent vertices
        LinkedList<node1> adj[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
        }
    }
    class node{
        
    }

    // find the vertex with minimum key value, from the set of vertices not yet
    // included in MST
    int minKey(int key[], boolean mstSet[]) {

    }
}
