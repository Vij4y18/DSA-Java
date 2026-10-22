package Cycles;

// https://takeuforward.org/practice/dsa/topological-sort-or-kahns-algorithm

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {

    private static void dfs (int node, boolean[] vis, Stack<Integer> st, List<List<Integer>> adj) {
        vis[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                dfs(neighbor,vis,st,adj);
            }
        }

        st.push(node);
    }

    private static int[] topoSort(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i=0; i<V; i++) {
            if (!vis[i]) {
                dfs(i,vis,st,adj);
            }
        }

        int[] result = new int[V];

        for (int i=0; i<V; i++) {
            result[i] = st.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        int V = 6;

        List<List<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(Arrays.asList()));
        adj.add(new ArrayList<>(Arrays.asList()));
        adj.add(new ArrayList<>(Arrays.asList(3)));
        adj.add(new ArrayList<>(Arrays.asList(1)));
        adj.add(new ArrayList<>(Arrays.asList(0, 1)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2)));

        int[] result = topoSort(V, adj);

        System.out.println(Arrays.toString(result));
    }
}
