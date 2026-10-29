package Hard_1;
import java.util.*;

public class ShortestPathUndirectedGraph {
    private static int[] shortestPath(int[][] edges, int N, int M) {
        // creating adj List
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<N; i++) adj.add(new ArrayList<>());

        for (int i=0; i<M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Processing nodes
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[N];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        q.offer(0);

        while (!q.isEmpty()) {
            int curr = q.poll();
            int currDist = dist[curr];

            if (currDist == Integer.MAX_VALUE) continue;

            for (int neighbor : adj.get(curr)) {
                if (dist[neighbor] == Integer.MAX_VALUE) {
                    dist[neighbor] = currDist + 1;
                    q.offer(neighbor);
                }
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
        int N = 9;
        int M = 10;

        int[][] edges = {
                {0, 1},
                {0, 3},
                {3, 4},
                {4, 5},
                {5, 6},
                {1, 2},
                {2, 6},
                {6, 7},
                {7, 8},
                {6, 8}
        };

        System.out.println(Arrays.toString(shortestPath(edges,N,M)));
    }
}
