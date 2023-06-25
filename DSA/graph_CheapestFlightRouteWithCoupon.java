package DSA;

import java.util.*;

// Pair class to store cost and vertex
class Pair {
    long first;
    int second;
    Pair(long a, int b) {
        first = a;
        second = b;
    }
}

// Node class to store vertex, coupon flag, and distance
class Node {
    int vertex;
    int couponFlag;
    long distance;
    Node(int vertex, int couponFlag, long distance) {
        this.vertex = vertex;
        this.couponFlag = couponFlag;
        this.distance = distance;
    }
}

public class graph_CheapestFlightRouteWithCoupon {
    static List<Pair>[] adj;
    static int n, m;
    static long[] dist, distc;
    static int[] par;
    static final long INF = (long) 1e17;

    public static void main(String[] args) {
        // Read input
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        // Initialize adjacency list
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Read edges and costs
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();
            adj[u].add(new Pair(c, v));
        }

        // Initialize distance and parent arrays
        dist = new long[n + 1];
        distc = new long[n + 1];
        par = new int[n + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(distc, INF);
        Arrays.fill(par, -1);

        // Call modified Dijkstra's algorithm
        dij(1);

        // Print the result
        System.out.println(distc[n]);
    }

    private static void dij(int src) {
        // Initialize priority queue with custom comparator
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(node -> node.distance));

        dist[src] = 0;
        distc[src] = 0;
        pq.offer(new Node(src, 0, 0));

        // Iterate through the priority queue
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int d = (int) node.distance;
            int u = node.vertex;
            int f = node.couponFlag;

            // Skip if better path is already known
            if (f == 1 && distc[u] < d) continue;
            if (f == 0 && dist[u] < d) continue;

            // Update distances considering the coupon flag
            for (Pair it : adj[u]) {
                int v = it.second;
                int weight = (int) it.first;
                if (f == 0) {
                    // Update distance without using the coupon
                    if (dist[v] > d + weight) {
                        dist[v] = d + weight;
                        par[v] = u;
                        pq.offer(new Node(v, 0, dist[v]));
                    }
                    // Update distance using the coupon
                    if (distc[v] > d + weight / 2) {
                        distc[v] = d + weight / 2;
                        par[v] = u;
                        pq.offer(new Node(v, 1, distc[v]));
                    }
                }
                // Update distance when the coupon is already used
                if (f == 1) {
                    if (distc[v] > d + weight) {
                        distc[v] = d + weight;
                        par[v] = u;
                        pq.offer(new Node(v, 1, distc[v]));
                    }
                }
            }
        }
    }
}
