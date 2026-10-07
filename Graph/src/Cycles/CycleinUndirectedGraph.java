package Cycles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Link -> https://takeuforward.org/practice/dsa/detect-a-cycle-in-an-undirected-graph?sidebar=0

public class CycleinUndirectedGraph {
    public static void main(String[] args) {
        int V = 6;
        List<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 3));
        adj[1].addAll(Arrays.asList(0, 2, 4));
        adj[2].addAll(Arrays.asList(1, 5));
        adj[3].addAll(Arrays.asList(0, 4));
        adj[4].addAll(Arrays.asList(1, 3, 5));
        adj[5].addAll(Arrays.asList(2, 4));

        System.out.println(isCycle(V, adj));
    }

    static boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];

        for (int i=0; i<V; i++) {
            if (!vis[i]) {
                if (dfs (i,-1,vis,adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs (int node, int parent, boolean[] vis, List<Integer>[] adj) {
        vis[node] = true;

        for (int neighbor : adj[node]) {
            if (!vis[neighbor]) {
                if (dfs(neighbor,node,vis,adj))
                    return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
}
