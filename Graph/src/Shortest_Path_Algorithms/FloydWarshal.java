package Shortest_Path_Algorithms;

import java.util.Arrays;
// https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1

public class FloydWarshal {
    // Runs in O(N3)
    private static void floydWarshall(int[][] dist) {
        // Code here
        int V = dist.length;

        for (int k=0; k<V; k++) {
            for (int i=0; i<V; i++) {
                for (int j=0; j<V; j++) {
                    if (dist[i][k] != 1e8 && dist[k][j] != 1e8) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] dist = {
                {0, 4, 108, 5, 108},
                {108, 0, 1, 108, 6},
                {2, 108, 0, 3, 108},
                {108, 108, 1, 0, 2},
                {1, 108, 108, 4, 0}
        };

        floydWarshall(dist);

        for (int[] it : dist) System.out.println(Arrays.toString(it));

    }
}
