package Cycles;

import java.util.ArrayList;
import java.util.List;

public class CycleInDirected {
    private static boolean dfs (int node, boolean[] vis, boolean[] visPath, List<List<Integer>> adj) {
        vis[node] = true;
        visPath[node] = true;

        for (int neighbor : adj.get(node)) {
            if (vis[neighbor] && visPath[neighbor]) {
                return true;
            } else if (!vis[neighbor]) {
                if (dfs(neighbor,vis,visPath,adj)) {
                    return true;
                }
            }
        }

        visPath[node] = false;
        return false;
    }

    private static boolean isCyclic(int V, int[][] edges) {
        // creating adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        boolean[] vis = new boolean[V];
        boolean[] visPath = new boolean[V];

        for (int i=0; i<V; i++) {
            if (!vis[i]) {
                if (dfs(i, vis, visPath, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 6;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 1},
                {4, 5}
        };

        System.out.println(isCyclic(V, edges));
    }
}
