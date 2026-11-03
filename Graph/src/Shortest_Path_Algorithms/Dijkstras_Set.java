package Shortest_Path_Algorithms;

import java.util.*;

public class Dijkstras_Set {
    private static int[] dijkstraSet (int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // creating adj list
        List<List<Pair>> adj = new ArrayList<>();

        for (int i=0; i<V; i++) adj.add(new ArrayList<>());

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);

            adj.get(u).add(new Pair(v, weight));
            adj.get(v).add(new Pair(u, weight));
        }

        // Implementing Dijkstras using Set
        TreeSet<Pair> st = new TreeSet<>((a,b) -> {
            if (a.distance != b.distance) {
                return Integer.compare(a.distance, b.distance);
            } else {
                return Integer.compare(a.node, b.node);
            }
        });

        st.add(new Pair(S,0));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        while (!st.isEmpty()) {
            Pair curr = st.pollFirst();
            int node = curr.node;
            int wt = curr.distance;

            if (wt > dist[node]) continue;

            for (Pair neighbor : adj.get(node)) {
                int neighborNode = neighbor.node;
                int neighborWt = neighbor.distance;

                if ((long)wt+neighborWt < dist[neighborNode]) {
                    if (dist[neighborNode] != Integer.MAX_VALUE) {
                        st.remove(new Pair(neighborNode, dist[neighborNode]));
                    }
                    dist[neighborNode] = wt + neighborWt;
                    st.add(new Pair(neighborNode,wt+neighborWt));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int V = 8;
        int S = 0;

        int[][] input = {
                {0, 1, 4},
                {0, 2, 2},
                {0, 3, 7},
                {1, 2, 1},
                {1, 4, 5},
                {2, 3, 3},
                {2, 4, 8},
                {2, 5, 6},
                {3, 5, 2},
                {4, 5, 1},
                {4, 6, 3},
                {5, 7, 4},
                {6, 7, 2}
        };

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        for (int[] edge : input) {
            edges.add(new ArrayList<>(Arrays.asList(
                    edge[0], edge[1], edge[2]
            )));
        }
        System.out.println(Arrays.toString(dijkstraSet(V, edges, S)));
    }
}
