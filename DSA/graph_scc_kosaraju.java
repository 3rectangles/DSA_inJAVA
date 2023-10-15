package DSA;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// do topo using dfs
// flip edges
//run dfs in reverse topo sort


public class graph_scc_kosaraju {
     public static class KosarajuSCC {
        private int n;
        private Stack<Integer> recursionStack = new Stack<>();
        private int components = 0;
        private boolean[] vis;
        private boolean[] vis2;
        private List<List<Integer>> componentsGrp = new ArrayList<>();
        private List<Integer> grp = new ArrayList<>();
        private List<List<Integer>> adj;
        private List<List<Integer>> adjTranspose;

        public KosarajuSCC(int n) {
            this.n = n;
            vis = new boolean[n];
            vis2 = new boolean[n];
            adj = new ArrayList<>(n);
            adjTranspose = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
                adjTranspose.add(new ArrayList<>());
            }
        }

        // Use this function to add directed edges to the graph and its transpose.
        public void addEdge(int u, int v) {
            adj.get(u).add(v);
            adjTranspose.get(v).add(u); // Add the reversed edge to the transpose graph
        }

        // Call this function before calling scc() to perform a topological sort on the graph using reverse DFS.
        public void reverseDfs(int u) {
            vis[u] = true;
            for (int v : adj.get(u)) {
                if (!vis[v]) {
                    reverseDfs(v);
                }
            }
            recursionStack.push(u);
        }

        // Call this function to find strongly connected components in the graph.
        public void scc() {
            while (!recursionStack.isEmpty()) {
                int node = recursionStack.pop();
                if (!vis2[node]) {
                    components++;
                    grp.clear();
                    dfs(node);
                    componentsGrp.add(new ArrayList<>(grp)); // important else shallow copy thing will happen
                }
            }
        }

        // This function is called internally by scc() to perform DFS on the reversed graph.
        private void dfs(int u) {
            vis2[u] = true;
            grp.add(u);
            for (int v : adjTranspose.get(u)) { // Use the transpose graph
                if (!vis2[v]) {
                    dfs(v);
                }
            }
        }

        public static void main(String[] args) {
            int m = 5;
            KosarajuSCC kosarajuSCC = new KosarajuSCC(m);
            kosarajuSCC.addEdge(1, 0);
            kosarajuSCC.addEdge(0, 2);
            kosarajuSCC.addEdge(2, 1);
            kosarajuSCC.addEdge(0, 3);
            kosarajuSCC.addEdge(3, 4);

            // Perform a topological sort on the graph using reverse DFS.
            for (int i = 0; i < m; i++) {
                if (!kosarajuSCC.vis[i]) {
                    kosarajuSCC.reverseDfs(i);
                }
            }

            // Find strongly connected components in the graph.
            kosarajuSCC.scc();
        }
    }

}