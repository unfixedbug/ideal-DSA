import java.util.*;

// only two colours in graph
// no adjacent nodes must have same colour
// cycle with odd length cycle cannot be bi-partite

/*
A biPartite Graph is a graph whose vertices can be divided into two disjoint(Independent) sets such that no two vertices of the same set are adjacent.
*/

// bipartite graph using bfs
class biPartiteGraphBFS {
    boolean bfsCheck(ArrayList<ArrayList<Integer>> adj, int start, int color[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 1;
        while (!q.isEmpty()) {
            Integer node = q.poll();
            for (Integer child : adj.get(node)) {
                if (color[child] == -1) {// uncoloured
                    color[child] = 1 - color[node];
                    q.add(child);
                } else if (color[child] == color[node]) { // if coloured and has same color
                    return false;
                }
            }
        }
        return true;
    }

    boolean chechBipartite(ArrayList<ArrayList<Integer>> adj, int n) {
        int color[] = new int[n]; // zero based indexing
        Arrays.fill(color, -1); // make all uncoloured -1, 0, 1
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(adj, i, color))
                    return false;
            }
        }
        return true;
    }
}

// dfs traversal to see biparttite graph
class biPartiteGraphDFS {
    boolean dfsCheck(ArrayList<ArrayList<Integer>> adj, int color[], int start) {
        if (color[start] == -1) { // only the (0)start node will be colourless
            color[start] = 1;
        }
        // this fn will color at least 1 node or return false
        for (Integer child : adj.get(start)) {
            if (color[child] == -1) {
                color[child] = 1 - color[start];
                if (!dfsCheck(adj, color, child)) {
                    return false;
                }
            } else if (color[child] == color[start])
                return false;
        }

        // even a single false can change the game
        return true;
    }

    boolean checkbiPartite(ArrayList<ArrayList<Integer>> adj, int n) {
        int color[] = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfsCheck(adj, color, i)) {
                    return false;
                }
            }
        }
        return true;
    }
}