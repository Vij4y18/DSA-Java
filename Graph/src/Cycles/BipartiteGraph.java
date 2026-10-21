package Cycles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BipartiteGraph {
    public static void main(String[] args) {
        int[][] graph = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };

        System.out.println(isBipartite(graph));
    }

    private static boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] vis = new int[v];
        Arrays.fill(vis, -1);

        for (int i=0; i<v; i++) {
            if (vis[i] == -1) {
                if (!dfs (i, 1, vis, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs (int node, int mark, int[] vis, int[][] graph) {
        vis[node] = mark;

        for (int neighbor : graph[node]) {
            if (vis[neighbor] == mark) {
                return false;
            }

            if (vis[neighbor] == -1) {
                int newMark = mark == 0 ? 1 : 0;
                if (!dfs(neighbor, newMark, vis, graph)) {
                    return false;
                }
            }
        }
        return true;
    }
}
