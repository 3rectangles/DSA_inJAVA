package DSA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class graph_subtree {
    static List<Integer>[] adj;
    static long[] size;
    static int n,m;
    public static void main(String[] args) {
        // Read the Graph
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt(); m= sc.nextInt(); //edges
        size = new long[n]; // defualt initialised to 0
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i =0 ; i < m ; i ++){
            int u = sc.nextInt(); int v= sc.nextInt();
            adj[u].add(v); adj[v].add(u); // tree: undirected graph
        }

        subtree(0);
    }

    private static void subtree(int u) {
        size[u] = 1; //atleast 1 node(itself) in the subtree

        long a =0;
        for(int child : adj[u] ){
            if( size[child] ==0 ) // not visited go and first calculate its size
                subtree(child);
            // child is visited now and has size calculated for its subtree
            a += size[child];

        }
    size[u] += a;
    }
}
