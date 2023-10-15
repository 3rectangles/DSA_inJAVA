package DSA;

import java.util.ArrayList;
import java.util.*;

public class
graph_checkcycle_directed_dfs {
    static int n ; // vertices
    static int m; // edges

    static ArrayList<Integer>[] adj; // initiate array of list
    static boolean[]vis;
    static Stack<Integer> path = new Stack<>(); // stack to keep track of nodes in path
     static int[] par;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        adj = new ArrayList[n];  // initialise array
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        //read edges
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(); int v = sc.nextInt();
            adj[u].add(v); // direced graph

        }

        // check for cycle, can be unconnected graph
        vis = new boolean[n]; // make boolean array to keep recorded for visited nodes
        par = new int[n];
        boolean cycle_found = false;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if(vis[i] == false){
                 if(dfs(i)){ // if dfs returns true then cycle found, nodes of cycle is inside stack
                     cycle_found =true;
                     break;
                 }
            }
        }
        List<Integer> cycle;
        cycle = new ArrayList<>();
        //par =par[start]; //get parent of start
        if(cycle_found) //retreive the cylce from stack
        {
            while (!path.isEmpty()) {
                cycle.add(path.pop());
            }
            System.out.println("Cycle found: " + cycle);
        }
        else
            System.out.println("no cycle found");
    }

    private static boolean dfs(int u) {
        vis[u] =true;
        path.add(u);
        for( int child : adj[u]){
            if( vis[child] && child != par[u]){ //cycle found
                return true;
            }
            else if (!vis[child]) //child not visited
            {
                boolean found =dfs(child);
                if (found)
                    return true;
            }


        }

        path.pop();
        return false;
    }


}
