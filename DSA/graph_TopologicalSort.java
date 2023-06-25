package DSA;
import java.util.*;
public class graph_TopologicalSort {

        // Function to perform topological sort using Kahn's algorithm
        public static List<Integer> toposort(List<List<Integer>> graph) {
            int n = graph.size();

            // Initialize in-degree of all nodes to 0
            int[] in_degree = new int[n];

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

            // Initialize empty list to store sorted nodes
            List<Integer> sorted_nodes = new ArrayList<>();

            while (!q.isEmpty()) {
                // Choose a node with in-degree 0
                int u = q.poll();

                // Add it to the sorted list
                sorted_nodes.add(u);

                // Remove outgoing edges and update in-degree of connected nodes
                for (int v : graph.get(u)) {
                    in_degree[v]--;
                    if (in_degree[v] == 0) {
                        q.add(v);
                    }
                }
            }

            // Check if graph contains a cycle
            if (sorted_nodes.size() != n) {
                // Return an empty list if graph contains a cycle
                sorted_nodes.clear();
            }

            // Return sorted list of nodes
            return sorted_nodes;
        }

        public static void main(String[] args) {
            int n = 6;
            int[][] edges = {{5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}};

            List<List<Integer>> graph = new ArrayList<>(n); // n the n passed as an argument is the initial capacity of the ArrayList.
            // It means that the ArrayList is created with enough space to store n elements without needing to resize its internal array.
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                graph.get(u).add(v); // Add directed edge (u, v) to the graph
            }

            // Compute topological sort of the graph
            List<Integer> sorted_nodes = toposort(graph);

            if (sorted_nodes.isEmpty()) {
                System.out.println("Graph contains a cycle!");
            } else {
                System.out.print("Topologically sorted nodes: ");
                for (int u : sorted_nodes) {
                    System.out.print(u + " ");
                }
                System.out.println();
            }
        }
    }