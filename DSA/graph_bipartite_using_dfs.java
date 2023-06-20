package DSA;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class graph_bipartite_using_dfs {
    static int bipartite(int node, int c, List<Integer>[] adj, int[] color, int[] vis) {
        // Giving colors using DFS
        color[node] = c;
        vis[node] = 1; // Marked visited

        for (int it : adj[node]) {
            if (vis[it] == 0) { // Not colored, give color opposite to node
                int x = bipartite(it, c ^ 1, adj, color, vis);
                if (x == -1) { // Not a bipartite graph
                    return -1;
                }
            } else { // Already colored
                if (color[it] == color[node]) {
                    return -1; // Not bipartite
                }
            }
        }

        return 1; // Path following "node" is bipartite
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n = no of vertices
        int m = sc.nextInt(); // m = edges

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) { // Taking edges
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v); // Undirected graph
            adj[v].add(u);
        }

        int[] color = new int[n];
        int[] vis = new int[n]; // Visited array

        for (int i = 0; i < n; i++) { // For all connected components, 0-based index of nodes
            if (vis[i] == 0) {
                int x = bipartite(i, 0, adj, color, vis); // Giving 0 color to i
                if (x == -1) {
                    System.out.println("Not a BIPARTITE GRAPH");
                }
            }
        }
    }
}

