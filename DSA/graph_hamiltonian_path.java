package DSA;

import java.util.*;

public class graph_hamiltonian_path {
    static int n ;
    static List<Integer>[] adj;
    static List<List<Integer>> dp;

    public static void main(String[] args) {


         n = 20; // change according to the question
        adj = new ArrayList[n];
        dp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            ArrayList<Integer> t = new ArrayList<>(1<<n);
            Collections.fill(t,-1);
            dp.add(t);
        }
        System.out.println(solve(0,0));
    }

    public static int solve(int u, int mask) {
        if (u == n && Integer.bitCount(mask) == n) // reached dest with all cities traveled
            return 1;
        if (u == n) return 0;

        if (dp.get(u).get(mask) != -1) return dp.get(u).get(mask);

        // visit unvisited cities
        long ans = 0;
        for (int city : adj[u]) {
            if ((mask & (1 << (city - 1))) != 0) // city is visited
                continue;
            // not visited
            ans = (ans + solve(city, mask ^ (1 << (city - 1)))) % 1000000007; // city index starts from 1
        }
        dp.get(u).set(mask, (int) ans);
        return (int) ans;
    }
}

