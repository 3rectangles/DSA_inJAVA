package DSA;

import java.util.*;

public class graph_all_paths_dfs {


    public static class Graph {
        private final int n;
        private final List<List<Integer>> adj;

        public Graph(int n) {
            this.n = n;
            adj = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int src, int dest) {
            adj.get(src).add(dest);
        }

        public List<List<Integer>> findAllPaths(int src, int dst) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            boolean[] visited = new boolean[n];

            dfs(src, dst, visited, path, result);
            return result;
        }

        /**
         The visited[src] = false line is important in this specific implementation
         because we are not keeping track of the parent node.
         If we were keeping track of the parent nodes,
         we could avoid using the visited array and instead ensure that we never visit the parent node while exploring the children of the current node.
         */
        private void dfs(int src, int dst, boolean[] visited, List<Integer> path, List<List<Integer>> result) {

            visited[src] = true;
            path.add(src);

            if (src == dst) {
                result.add(new ArrayList<>(path));
            } else {
                for (int neighbor : adj.get(src)) {
                    if (!visited[neighbor]) {
                        dfs(neighbor, dst, visited, path, result);
                    }
                }
            }

            path.remove(path.size() - 1);
            visited[src] = false; // important else a node wil never visited for some other path, in case of cycles
        }

        public static void main(String[] args) {
            Graph graph = new Graph(4);
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(0, 3);
            graph.addEdge(2, 0);
            graph.addEdge(2, 1);
            graph.addEdge(1, 3);

            int src = 2;
            int dst = 3;

            List<List<Integer>> paths = graph.findAllPaths(src, dst);
            System.out.println("All paths from " + src + " to " + dst + ":");
            for (List<Integer> path : paths) {
                System.out.println(path);
            }
        }
    }

}