package Shortest_Path_Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
// https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1

public class BellmanFord {
    private static int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i=0; i<V-1; i++) {
            // Relaxation for N-1 times
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], edgeWt = edge[2];

                if (dist[u] != Integer.MAX_VALUE && dist[u] + edgeWt < dist[v]) {
                    dist[v] = dist[u] + edgeWt;
                }
            }
        }

        // Nth itheration fro cycle detection
        ArrayList<Integer> res = new ArrayList<>();

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], edgeWt = edge[2];

            if(dist[u] != Integer.MAX_VALUE && dist[u] + edgeWt < dist[v]) {
                return new int[] {-1};
            }
        }

        // if no negative cycle exist you can return dist[]
        return dist;
    }

    public static void main(String[] args) {
        int V = 5;

        int[][] edges = {
                {1, 3, 2},
                {4, 3, -1},
                {2, 4, 1},
                {1, 2, 1},
                {0, 1, 5}
        };

        int src = 0;

        System.out.println(Arrays.toString(bellmanFord(V, edges, src)));
    }
}
