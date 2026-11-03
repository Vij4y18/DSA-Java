package Shortest_Path_Algorithms;
import java.util.*;

// problem link: https://takeuforward.org/practice/dsa/dijkstra's-algorithm
class Pair {
    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class Dijkstras_PQ {
    private static int[] dijkstraPQ(int V, ArrayList<ArrayList<Integer>> edges, int S) {
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

        // Implementing Dijkstras using Min Heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.weight, b.weight));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        pq.offer(new Pair(S,0));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int wt = pq.peek().weight;
            pq.remove();

            if (wt > dist[node]) continue;

            for (Pair neighbor : adj.get(node)) {
                int nieghborNode = neighbor.node;
                int neighborWt = neighbor.weight;

                if ((long)wt+neighborWt < dist[nieghborNode]) {
                    dist[nieghborNode] = wt + neighborWt;
                    pq.offer(new Pair(nieghborNode,wt+neighborWt));
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


        System.out.println(Arrays.toString(dijkstraPQ(V, edges, S)));
    }
}
