package Hard_1;

// Problem Link: https://leetcode.com/problems/find-eventual-safe-states/

import java.util.*;

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

    private static List<Integer> eventualSafeNodesBFS(int[][] graph) {
        int V = graph.length;;

        // reversing the given adj graph to perform BFS
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i=0; i<V; i++) {
            adjRev.add(new ArrayList<>());
        }

        for (int i=0; i<V; i++) {
            for (int j=0; j<graph[i].length; j++) {
                int neighbor = graph[i][j];
                adjRev.get(neighbor).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int[] inDegree = new int[V];

        for (int i=0; i<V; i++) {
            for (int adj : adjRev.get(i)) {
                inDegree[adj]++;
            }
        }

        for (int i=0; i<V; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            for (int neighbor : adjRev.get(curr)) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        Collections.sort(res);
        return res;
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
        // System.out.println(eventualSafeNodesBFS(graph));
        System.out.println(eventualSafeNodesDFS(graph));
    }
}
