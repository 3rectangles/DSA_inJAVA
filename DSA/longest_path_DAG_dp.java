package DSA;

import java.util.*;

// for DAG we can use dp, bec no cycles
// the concept is like subtree only, for any node, add the longest chain of child.
// it doesnt matter from which node u start, bec starting from any node, longest chain will be calculated to the very bottom
//and stored dp[node2] : longest chain to leaf, and calculated for every child like in subtree
// later if node2 is in node1 path we can use used caching -->  dp[node1] += dp[node2]


public class longest_path_DAG_dp {

    static class pair{
        int first,second;
        pair(int a,int b) {first =a; second =b;}
    }
    static List<pair>[] adj;
    static int n, m;
    static boolean[] vis;
    static int[] dp ;
    static  int result =Integer.MIN_VALUE;

    public static void main(String[] args) {
        read_wt_graph();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) { // for connected graphs component
            if(!vis[i])  longest_path(i);

        }



    }
    public static void longest_path(int i){
        dp[i] =0;
        List<Integer> top= new ArrayList<>(2);
        for ( pair child :adj[i]){
            int u = child.first;
            int wt = child.second; // wt is length of path
            if(!vis[u]) //not visited hence its longest path not calculated
                longest_path(u);
            // for every child find the best child
            dp[i] = Math.max(dp[i], dp[u] +1);
            // store 2 best child
            if( dp[u] > top.get(2))
            {
                top.set(2,dp[u]);
                Collections.sort(top);
            }

        }
        //calculated longest path starting from i
        result = Math.max(result, dp[i]);
        // longest path taking i in btw
        result = Math.max(result, top.get(0)+top.get(1)+1);

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
