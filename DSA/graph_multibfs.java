package DSA;

import java.util.*;

public class graph_multibfs {
    static List<Integer>[] adj;
    static int n, m;
    static int timer = 0;
    static boolean[] vis;
    static int[] dis ;
    static List<List<Integer>> levels = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        read_graph();
        vis = new boolean[n]; // by default false
        dis = new int[n]; //
        // enter multiple starting points in the queue
        int numSources = sc.nextInt();
        for (int i = 0; i < numSources; i++) {
            int src = sc.nextInt();
            queue.offer(src);
        }

        // will store nodes visited in each second/level
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            timer++; // secs required to visit all nodes
            // visit all the elements in the queue, whose children will be visited in this iteration/sec/Level
            for (int i = 0; i < size; i++) {
                int u = queue.poll();
                for (int child : adj[u]) {
                    if (!vis[child]) { // child not visited
                        queue.offer(child);
                        vis[child] = true; // push and mark
                        level.add(child); // visited in this level
                        dis[child] = dis[node] + 1; // level inc or distance from source nodes
                    }
                    else if (vis[child] == 1) { // already visited either parent or visited by some other source
                        // acc to ques
                    }
                }
            }
            levels.add(level); // used to keep track of nodes visited in ith sec
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
