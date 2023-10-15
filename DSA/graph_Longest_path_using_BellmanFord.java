package DSA;
import java.util.ArrayList;
import java.util.List;

// mulitply all edges weight by -1 to find single source longest path

public class graph_Longest_path_using_BellmanFord {


    // Class to store the edge information
    static class Triplet {  // nested inner class
        int first;  // Source vertex
        int second; // Destination vertex
        int third;  // Weight of the edge
    }


        static long inf = (long) 1e17 + 1000; // Define a large value to represent infinity
        static List<Integer> dis = new ArrayList<>(); // List to store the shortest distance from the source to each vertex
        static List<Triplet> edges = new ArrayList<>(); // List to store the edges of the graph

        public static int bellmanFord(int src, int n, int m) {
            // Initialize all distances to infinity except the source vertex
            for (int i = 0; i <= n; i++) {
                dis.add((int) inf);
            }
            dis.set(src, 0);

            // Relax all edges for n-1 iterations
            for (int i = 1; i < n - 1; i++) {
                boolean flag = false;
                // Iterate through all edges
                for (Triplet e : edges) {
                    int u = e.first;
                    int v = e.second;
                    int wt = e.third;
                    // If the distance to the source vertex is infinity, skip this edge
                    if (dis.get(u) == inf) continue;
                    // Relax the edge if a shorter path is found
                    if (dis.get(v) > dis.get(u) + wt) {
                        dis.set(v, dis.get(u) + wt);
                        flag = true;

                    }
                }

                // If no relaxation occurred in this iteration, break the loop
                if (!flag)
                    break;
            }

            // Check for negative cycles
            for (int e = 1; e <= m; e++) {
                int u = edges.get(e).first;
                int v = edges.get(e).second;
                int wt = edges.get(e).third;
                // If a shorter path is still found after n-1 iterations, there is a negative cycle
                if (dis.get(v) > dis.get(u) + wt) {
                    return -1;
                }
            }

            return 0;
        }

        public static void main(String[] args) {
            // Add edges to the graph
            Triplet edge1 = new Triplet();
            edge1.first = 1;
            edge1.second = 2;
            edge1.third = 3;
            edges.add(edge1);

            Triplet edge2 = new Triplet(); // can initiate nested static class inside outer class method without outer class name
            edge2.first = 2;
            edge2.second = 3;
            edge2.third = 4;
            edges.add(edge2);

            // Call the bellmanFord function with the source vertex, number of vertices (n), and number of edges (m)
            int result = bellmanFord(1, 3, 2);
            System.out.println("Result: " + result);
        }
    }
