import java.util.concurrent.Flow;

// all pairs shortest path, shortest distance between any vertex to any vertex

// T(n) = O(V^3)

public class floydWarshal {
    final static int INF = 99999, v = 4; // number of vretices

    void floydWarshall(int graph[][]) { // adjacency matrix
        int dist[][] = new int[v][v];
        int i, k, j;
        for (i = 0; i < v; i++)
            for (j = 0; j < v; j++)
                dist[i][j] = graph[i][j];

        // tattialgo bc
        for (k = 0; k < v; k++) {
            for (i = 0; i < v; i++) {
                for (j = 0; j < v; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        // print the solution
        printSolution(dist);

    }

    void printSolution(int dist[][]) {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        /*
         * Let us create the following weighted graph 10 (0)------->(3) | /|\ 5 | | | |
         * 1 \|/ | (1)------->(2) 3
         */
        int graph[][] = { { 0, 5, INF, 10 }, { INF, 0, 3, INF }, { INF, INF, 0, 1 }, { INF, INF, INF, 0 } };
        floydWarshal a = new floydWarshal();

        // Print the solution
        a.floydWarshall(graph);
    }
}
