package Hard_1;

// Problem Link: https://leetcode.com/problems/find-eventual-safe-states/

import java.util.ArrayList;
import java.util.List;

public class SafeStates {
    private static boolean dfsCheck (int node, int[] vis, int[] visPath, int[] mark, int[][] graph) {
        vis[node] = 1;
        visPath[node] = 1;
        mark[node] = 0;

        for (int neighbor : graph[node]) {
            if (vis[neighbor] == 0) {
                if (dfsCheck(neighbor,vis,visPath,mark,graph)) {
                    return true;
                }
            }

            if (visPath[neighbor] == 1) {
                return true;
            }
        }

        mark[node] = 1;
        visPath[node] = 0;
        return false;
    }

    private static List<Integer> eventualSafeNodesDFS(int[][] graph) {
        int V = graph.length;
        int[] vis = new int[V];
        int[] visPath = new int[V];
        int[] mark = new int[V];

        for (int i=0; i<V; i++) {
            if (vis[i] == 0) {
                dfsCheck(i,vis,visPath,mark,graph);
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i=0; i<V; i++) {
            if (mark[i] == 1) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        System.out.println(eventualSafeNodesDFS(graph));
    }
}
