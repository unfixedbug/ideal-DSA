
import java.util.*;

public class ArrivalDepartureTIme {
    public static int  DFS(Graph graph, int v, boolean[] visited, int arrival[], int departure[], int time) {
        
        arrival[v] = time++;
        visited[v] = true;
        for(int i:graph.adjList.get(v)){
            if(!visited[i]){
                time  = DFS(graph, i, visited, arrival, departure, time));
            }
        }
        departure[v] = time++;
        return time;
        
    }

    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 2), new Edge(2, 3), new Edge(2, 4),
                new Edge(3, 1), new Edge(3, 5), new Edge(4, 5), new Edge(6, 7)
        );
 
        // total number of nodes in the graph (labelled from 0 to 7)
        int n = 8;
 
        // build a graph from the given edges
        Graph graph = new Graph(edges, n);
 
        // array to store the arrival time of vertex
        int[] arrival = new int[n];
 
        // array to store the departure time of vertex
        int[] departure = new int[n];
 
        // mark all the vertices as not discovered
        boolean[] discovered = new boolean[n];
        int time = -1;
 
        // Perform DFS traversal from all undiscovered nodes to
        // cover all unconnected components of a graph
        for (int i = 0; i < n; i++)
        {
            if (!discovered[i]) {
                time = DFS(graph, i, discovered, arrival, departure, time);
            }
        }
 
        // print arrival and departure time of each vertex in DFS
        for (int i = 0; i < n; i++)
        {
            System.out.println("Vertex " + i + " (" + arrival[i] + ", " +
                departure[i] + ")");
        }
}
