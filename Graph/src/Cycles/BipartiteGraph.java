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
        List<List<Integer>> adj = new ArrayList<>();
        int[] vis = new int[v];
        Arrays.fill(vis, -1);

        //creating adjacency list
        for (int i=0; i<v; i++) {
            List<Integer> li = new ArrayList<>();
            for (int j=0; j<graph[i].length; j++) {
                li.add(graph[i][j]);
            }
            adj.add(li);
        }

        for (int i=0; i<v; i++) {
            if (vis[i] == -1) {
                if (!dfs (i, 1, vis, adj)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs (int node, int mark, int[] vis, List<List<Integer>> adj) {
        vis[node] = mark;

        for (int neighbor : adj.get(node)) {
            if (vis[neighbor] == mark) {
                return false;
            }

            if (vis[neighbor] == -1) {
                int newMark = mark == 0 ? 1 : 0;
                if (!dfs(neighbor, newMark, vis, adj)) {
                    return false;
                }
            }
        }
        return true;
    }
}
