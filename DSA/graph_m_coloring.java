package DSA;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.*;


public class graph_m_coloring {
    static void giveColor(int i, int n, List<Integer>[] adj, Map<Integer, List<Integer>> color, boolean[] vis) {
        // Using bfs to give min possible colors
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        boolean[] colorUsed = new boolean[n / 2 + 2]; // Check which color have been used in neighbours
        int[] haveColor = new int[n]; // Which node have which color

        while (!q.isEmpty()) {
            // Go to neighbours, check which colors have been assigned and assign lowest available color
            int node = q.poll();
            vis[node] = true; // Will be colored
            Arrays.fill(colorUsed, false);
            for (int it : adj[node]) { // Adjacent
                if (!vis[it]) { // Unvisited, don't have color
                    q.add(it); // Will be assigned color
                } else { // Have color or is in the queue, to be assigned color later
                    colorUsed[haveColor[it]] = true;
                }
            }
            // Assign available color
            int colorIndex = 1;
            while (colorIndex < colorUsed.length && colorUsed[colorIndex]) {
                colorIndex++;
            }
            // If(colorIndex > 2) System.out.println("Not a bipartite graph");
            haveColor[node] = colorIndex;
            color.computeIfAbsent(colorIndex, k -> new ArrayList<>()).add(node); // Which nodes have ith color
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n= no of vertices
        int m = sc.nextInt(); // m = edges
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) { // Taking edges
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v); // Undirected graph
            adj[v].add(u);
        }

        Map<Integer, List<Integer>> color = new HashMap<>(); // Store which nodes are given which color, int is key(color no)
        boolean[] vis = new boolean[n]; // Visited array

        for (int i = 0; i < n; i++) { // For all connected components, 0 based index of nodes
            if (!vis[i]) {
                color.clear();
                giveColor(i, n + 10, adj, color, vis);
                // If(color.size() == 2) System.out.println("BIPARTITE GRAPH");
            }
        }

    }
}

