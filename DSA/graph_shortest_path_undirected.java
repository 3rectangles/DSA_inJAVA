package DSA;

import java.util.*;

public class graph_shortest_path_undirected {

    static List<Integer>[] adj;
    static int n, m;
    static boolean[] vis;
    static int[] dis ;
    static int[] par; static int[] path;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        read_graph();
        vis = new boolean[n]; // by default false
        dis = new int[n]; // dis of shortest path from source
        Arrays.fill(dis,Integer.MAX_VALUE); // all dist are inf in starting
        par = new int[n]; // par of each node
        Arrays.fill(par,-1);// Initialize an array to store the parent node of each node in the shortest path tree. We initialize each value to -1 to represent that the nodes are not reachable from the source yet.
        path = new int[n]; // stores count of shortest paths
        // enter multiple starting points in the queue
        int src = sc.nextInt();
        queue.offer(src); dis[src]=0; path[src]=1;
        while (!queue.isEmpty()) {
           int u = queue.poll();
           for ( int child:adj[u]){
               if( dis[child] > dis[u] +1) {
                   dis[child] = dis[u] +1;
                   path[child] = path[u];
                   par[child]=path[u];
               }
               else if( dis[child] == dis[u]+1) //found another shortest path
               {
                   path[child] += path[u];
               }
               // if dis[child] < dis[u]+1 ( child is par) already visited its unit weight graph
           }
        }
    }

    private static void read_graph() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // read graph
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u); // undirected graph
        }
    }
}

