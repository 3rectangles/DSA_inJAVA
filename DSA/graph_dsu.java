package DSA;// Import required Java utilities
import java.util.ArrayList;
import java.util.Scanner;

// Create a GraphDSU class to implement Disjoint Set Data Structure
public class graph_dsu {
    // Initialize the size of the graph, the list of edges, and the parent and rank arrays
    static int n = (int) 1e5;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int[] par = new int[n];
    static int[] rank = new int[n];

    // Define an Edge class to represent an edge in the graph
    static class Edge {
        int u;
        int v;
        int wt;

        // Constructor to initialize an Edge object with source, destination, and weight
        public Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    // The find() method returns the representative of the set that the input node belongs to
    public static int find(int u) {
        if (par[u] < 0)
            return u;
        return par[u] = find(par[u]);
    }

    // The merge() method takes two nodes as input and merges their sets
    public static void merge(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (rank[a] > rank[b]) {
            par[a] += par[b];
            par[b] = a;
        } else if (rank[b] > rank[a]) {
            par[b] += par[a];
            par[a] = b;
        } else {
            par[a] += par[b];
            par[b] = a;
            rank[a]++;
        }
    }

    // The addEdges() method checks for cycles in the graph and merges the sets of source and destination nodes
    public static void addEdges() {
        for (Edge e : edges) {
            if (find(e.u) == find(e.v))
                System.out.println("cycle");
            merge(e.u, e.v);
        }
    }

    // The main() method reads input edges, initializes the edges ArrayList, and calls the addEdges() method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        while (m-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();
            edges.add(new Edge(u, v, wt));
        }
        addEdges();
        sc.close();
    }
}
