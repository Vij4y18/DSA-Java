package Cycles;

import java.util.*;

// Using BFS here
public class CycleinUndirectedGraph2 {
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
                if (bfs (i,vis,adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean bfs (int node, boolean[] vis, List<Integer>[] adj) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(node,-1));
        vis[node] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int currNode = curr.node;
            int parent = curr.parent;

            for (int neighbor : adj[currNode]) {
                if (!vis[neighbor]) {
                    q.offer(new Pair(neighbor, currNode));
                    vis[neighbor] = true;
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Pair {
    int node;
    int parent;

    public Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

