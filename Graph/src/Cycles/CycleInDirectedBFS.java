package Cycles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleInDirectedBFS {
    private static boolean isCyclic (int V, int[][] edges) {
        // creating adjacency list and calculating indegree
        int[] inDegree = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            inDegree[v]++; // Calculating indegree
        }

        // Applying Kahn's Algo
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.offer(i); // adding Node with zero indegree
            }
        }

        int cnt = 0; // to check if we processed all nodes

        while (!q.isEmpty()) {
            int curr = q.poll();
            cnt++;

            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return cnt != V;
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
