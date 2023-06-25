package DSA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
--Eulerian Path/Circuit algorithm (Hierholzers algorithm) in graph --
 // https://www.youtube.com/watch?v=8MpoO2zA2l4
 cses ques https://cses.fi/problemset/task/1693
*/
public class graph_eulerian_path {


    // Global variables to store the answer, in-degree, out-degree, and adjacency lists
    static List<Integer> ans = new ArrayList<>();
    static int[] in;
    static int[] out;
    static List<Integer>[] adj;
    static int n,m;

    public static void main(String[] args) {
        // Read input graph from the user
        Scanner scanner = new Scanner(System.in);
         n = scanner.nextInt();
        m = scanner.nextInt();
        in = new int[n + 1];
        out = new int[n + 1];
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj[u].add(v);
            out[u]++;
            in[v]++;
        }
        // Check if the Eulerian path exists and print the result
        if (eulerian() > 0) {
            System.out.println("Path exists in ans vector");
        } else {
            System.out.println("Path doesn't exist");
        }
    }

    // Function to check if the graph has an Eulerian path and find it if it exists
    static int eulerian() {
        // check if exist
        //  decide starting  point
        // run dfs and store the path
        // chewck if contains all edges for no disconnected graph


        // Check if the graph has the necessary conditions for an Eulerian path
        if (!exists()) {
            return -1;
        }
        // Find the starting point of the Eulerian path
        int start = startpoint();
        // Perform DFS from the starting point to find the Eulerian path
        dfs(start);
        // If the size of the ans list is equal to the number of edges + 1, the path is found
        if (ans.size() == m + 1) {
            return 1;
        }
        return -1;
    }

    // DFS function to traverse the graph and find the Eulerian path
    static void dfs(int u) {
        // Continue the traversal until there are no more outgoing edges from the current vertex
        while (out[u] > 0) {
            // Recursively call dfs for the last vertex in the adjacency list of the current vertex
            dfs(adj[u].get(adj[u].size() - 1));
            // Remove the last vertex from the adjacency list and decrement the out-degree of the current vertex
            adj[u].remove(adj[u].size() - 1);
            out[u]--;
        }
        // Add the current vertex to the ans list as part of the Eulerian path
        ans.add(u);
    }

    // Function to find the starting point of the Eulerian path
    static int startpoint() {
        //for euler path: start point is node having out[i]==in[i]+1
        // for undirected graph: start point is node having odd edges. note undirected graph has total even degree.
// odd degree appears in pairs
        int startpoint = 1;
        for (int i = 1; i <= n; i++) {
            // If the out-degree of a vertex is equal to its in-degree + 1, it is the starting point
            if (out[i] == in[i] + 1) {
                return i;
                // Otherwise, if the out-degree is greater than 0, it is a candidate for the starting point
            } else if (out[i] > 0) {
                startpoint = i;
            }
        }
        return startpoint;
    }

    // Function to check if the graph has the necessary conditions for an Eulerian path

    static boolean exists() {
        //checks: if indegree= outdegree (even) for all nodes. start and point can be exception
        //  in euler path start point has 1 extra out degree, in point have 1 extra in degree. they appear together
        // for euler circuit all nodes have outdgree == indgree
        // for undirected graph-- even degree for all nodes, except  for start and end point can have odd degree
        int start = 0;
        int end = 0;
        for (int i = 1; i <= n; i++) {
            // If the out-degree and in-degree are equal, continue to the next vertex
            if (out[i] == in[i]) {
                continue;
            }
            // Count the vertices with out-degree = in-degree + 1 and in-degree = out-degree + 1
            if (out[i] == in[i] + 1) {
                start++;
            } else if (in[i] == out[i] + 1) {
                end++;
            }
            // If the difference between in-degree and out-degree is greater than 1, the graph doesn't have an Eulerian path
            if (out[i] > in[i] + 1 || in[i] > out[i] + 1) {
                return false;
            }
        }
        // If there is exactly one vertex with out-degree = in-degree + 1 and one vertex with in-degree = out-degree + 1, the graph has an Eulerian path
        if (start == 1 && end == 1) {
            return true;
        }
        // If all vertices have equal in-degree and out-degree, the graph has an Eulerian path
        return start == 0 && end == 0;
    }
}
