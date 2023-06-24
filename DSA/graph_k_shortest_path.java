package DSA;

import java.util.*;


public class graph_k_shortest_path {
    static List<pair>[] adj;
    static int n, m;
    static int[][] dis ;
    static PriorityQueue<pair> pq = new PriorityQueue<>( (p1, p2)-> p1.first- p2.second); // max priority queue
     static    int k =5;

    public static void main(String[] args) {
        read_wt_graph();
        Scanner sc = new Scanner(System.in);
        int src = sc.nextInt();
        dis = new int[n][k];
        for (int[] row : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Arrays.fill(dis[src],0);

        dij(src);

    }

    private static void dij(int src) {

        pq.offer(new pair(0,src));
        while(!pq.isEmpty()){
            pair node = pq.poll();//  {dis, u}
            int d = node.first; //dis to reach this u
            int u = node.second;
            if( dis[u][k-1] < d )// we already have shorter dis to u
                continue;
            for( pair n: adj[u]){
                int child = n.first;
                int wt =n.second;
                if(dis[child][k-1] > d + wt)
                {
                    dis[child][k-1] = d + wt;
                    Arrays.sort(dis[child]);
                    pq.offer(new pair(dis[child][k-1], child));
                }
            }
        }
    }




    private static void dij2(int src) {
        // if dis is list and not 2d array
        List<List<Integer>> dis; // this shadows the static variable
        dis = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(k, Integer.MAX_VALUE));
            dis.add(row);
        }

        Collections.fill(dis.get(src), 0);


        // Add the source node with distance 0 to the priority queue
        pq.offer(new pair(0, src));

        // While the priority queue is not empty
        while (!pq.isEmpty()) {
            // Poll the node with the smallest distance from the priority queue
            pair node = pq.poll();
            int d = node.first;
            int u = node.second;

            // If the k-th shortest distance to the current node is already smaller than the polled distance,
            // it means we already have a better path, so we skip this node
            if (dis.get(u).get(k - 1) < d)
                continue;

            // Iterate through the neighbors of the current node
            for (pair n : adj[u]) {
                int child = n.first;
                int wt = n.second;

                // If the k-th shortest distance to the child node is greater than the distance to the current node plus the weight,
                // it means we found a shorter path to the child node
                if (dis.get(child).get(k - 1) > d + wt) {
                    // Update the k-th shortest distance to the child node
                    dis.get(child).set(k - 1, d + wt);

                    // Sort the distances list for the child node
                    Collections.sort(dis.get(child));

                    // Add the updated child node to the priority queue
                    pq.offer(new pair(dis.get(child).get(k - 1), child));
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
