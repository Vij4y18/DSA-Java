package Hard_1;
import java.util.*;


// https://takeuforward.org/practice/dsa/shortest-path-in-dag

class Pair {
    int node;
    int dist;

    Pair (int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

public class ShortestPathDAG {
    private static Stack<Integer> st;
    private static boolean[] vis;

    private static void topoDFS (int node, List<List<Pair>> adj) {
        vis[node] = true;

        for (Pair neighbor : adj.get(node)) {
            int nieghborNode = neighbor.node;

            if (!vis[nieghborNode]) {
                topoDFS(nieghborNode,adj);
            }
        }

        st.push(node);
    }

    private static int[] shortestPath(int N, int M, int[][] edges) {
        // creating adj list
        List<List<Pair>> adj = new ArrayList<>();

        for (int i=0; i<N; i++) adj.add(new ArrayList<>());

        for (int i=0; i<M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int dist = edges[i][2];

            adj.get(u).add(new Pair(v,dist));
        }

        // performing Topo Sort
        st = new Stack<>();
        vis = new boolean[N];

        for (int i=0; i<N; i++) {
            if (!vis[i]) {
                topoDFS(i,adj);
            }
        }

        // Calculating Shortest path
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (!st.isEmpty()) {
            int currNode = st.pop();
            int currDist = dist[currNode];

            if (currDist == Integer.MAX_VALUE) continue;

            for (Pair neighbor : adj.get(currNode)) {
                int nieghborNode = neighbor.node;
                int neighborDist = neighbor.dist;

                dist[nieghborNode] = Math.min (dist[nieghborNode], currDist+neighborDist);
            }
        }

        for (int i=0; i<N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int N = 8;
        int M = 10;

        int[][] edges = {
                {0, 1, 4},
                {0, 2, 2},
                {1, 3, 2},
                {2, 1, 1},
                {2, 3, 7},
                {1, 4, 3},
                {3, 4, -2},
                {4, 5, 2},
                {3, 5, 5},
                {6, 7, 1}
        };

        System.out.println(Arrays.toString(shortestPath(N, M, edges)));
    }
}
