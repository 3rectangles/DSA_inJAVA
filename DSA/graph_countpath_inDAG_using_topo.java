package DSA;
import java.util.*;

public class graph_countpath_inDAG_using_topo {

    // Function to perform toposort and count paths from source to destination
        public static int countPaths(ArrayList<ArrayList<Integer>> graph, int source, int dest) {
            int n = graph.size();
            int[] in_degree = new int[n]; // Initialize in-degree of all nodes to 0
            int[] num_paths = new int[n]; // Initialize number of paths to all nodes to 0
            num_paths[source] = 1; // There is 1 path to the source node

            // Compute in-degree of each node
            for (int u = 0; u < n; u++) {
                for (int v : graph.get(u)) {
                    in_degree[v]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            // Add all nodes with in-degree 0 to the queue
            for (int u = 0; u < n; u++) {
                if (in_degree[u] == 0) {
                    q.add(u);
                }
            }

            while (!q.isEmpty()) {
                int u = q.poll(); // Choose a node with in-degree 0
                for (int v : graph.get(u)) { // Remove outgoing edges and update number of paths to connected nodes
                    num_paths[v] += num_paths[u];
                    in_degree[v]--;
                    if (in_degree[v] == 0) {
                        q.add(v);
                    }
                }
            }
            return num_paths[dest]; // Return number of paths to destination node
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.get(u).add(v); // Add directed edge (u, v) to the graph
            }
            int source = sc.nextInt();
            int dest = sc.nextInt();
            int num_paths = countPaths(graph, source, dest); // Count number of paths from source to destination
            System.out.println("Number of paths from " + source + " to " + dest + " = " + num_paths);
            sc.close();
        }
    }

