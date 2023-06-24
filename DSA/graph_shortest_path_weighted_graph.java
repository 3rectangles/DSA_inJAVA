package DSA;

import java.util.*;

class pair{
    int first,second;
    pair(int a,int b) {first =a; second =b;}
}
public class graph_shortest_path_weighted_graph {
    static List<pair>[] adj;
    static int n, m;
    static boolean[] vis;
    static int[] dis ;
    static int[] par; static int[] path;
    static PriorityQueue<pair> pq = new PriorityQueue<>( (p1,p2)-> p1.first- p2.second); // min priority queue heap

    public static void main(String[] args) {
        read_wt_graph();
        Scanner sc = new Scanner(System.in);
        int src = sc.nextInt();
        dis = new int[n]; Arrays.fill(dis,Integer.MAX_VALUE);
        par = new int[n]; Arrays.fill(par,-1);
        path = new int[n]; Arrays.fill(path,0); //0 shortest path to all
        path[src] = 1; // Set the number of paths to the source node as 1
        dij(src);

    }

    private static void dij(int src) {
        dis[src]=0;
        pq.offer(new pair(0,src));
        while(!pq.isEmpty()){
            pair node = pq.poll();//  {dis, u}
            int d = node.first; //dis to reach this u
            int u = node.second;

            if( dis[u] < d )// we already have shorter dis to u
                continue;
            for( pair n: adj[u]){
                int child = n.first;
                int wt =n.second;
                if(dis[child] > d + wt)
                {
                    dis[child] = d + wt;
                    pq.offer(new pair(dis[child], child));
                    par[child]= u; path[child] =path[u];
                } else if ( dis[child] == d + wt) {
                    path[child] += path[u] ; // more paths found

                }

            }
        }


    }

    private static void read_wt_graph() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // read graph
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(); int v = sc.nextInt(); int w = sc.nextInt();
            adj[u].add(new pair(v,w));
        }
    }


}
