package Shortest_Path_Algorithms;
import java.util.*;

public class PrintShortestPath {
    private static List<Integer> shortestPath(int n, int m, int[][] edges) {
        // creating adj list
        List<List<Pair>> adj = new ArrayList<>();

        for (int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        // implementing Dijkstras
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.distance, b.distance));
        pq.offer(new Pair(1, 0));
        int[] parent = new int[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        for (int i = 1; i <= n; i++) parent[i] = i;


        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int currNode = curr.node;
            int currDist = curr.distance;

            if (currDist > dist[currNode]) continue;

            for (Pair neighbor : adj.get(currNode)) {
                int neighborNode = neighbor.node;
                int edgeWeight = neighbor.distance;
                int neighborDist = currDist + edgeWeight;

                if (neighborDist < dist[neighborNode]) {
                    dist[neighborNode] = neighborDist;
                    parent[neighborNode] = currNode;
                    pq.offer(new Pair(neighborNode, neighborDist));
                }
            }
        }

        List<Integer> resPath = new ArrayList<>();

        if (dist[n] == Integer.MAX_VALUE) return resPath;

        int node = n;

        while (parent[node] != node) {
            resPath.add(node);
            node = parent[node];
        }
        resPath.add(1);
        resPath.add(dist[n]);
        Collections.reverse(resPath);

        return resPath;
    }

    public static void main(String[] args) {
        int n = 6;
        int m = 8;

        int[][] edges = {
                {1, 2, 4},
                {1, 3, 2},
                {2, 3, 1},
                {2, 4, 5},
                {3, 4, 8},
                {3, 5, 10},
                {4, 5, 2},
                {4, 6, 6},
                {5, 6, 3}
        };

        System.out.println(shortestPath(n,m,edges));
    }
}
