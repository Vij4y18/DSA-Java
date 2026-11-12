package Shortest_Path_Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class TimePair {
    int node;
    Long time;


    TimePair (int node, long time) {
        this.node = node;
        this.time = time;
    }
}

public class No_of_Ways {
    private static int countPaths(int n, int[][] roads) {
        List<List<TimePair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];

            adj.get(u).add(new TimePair(v, time));
            adj.get(v).add(new TimePair(u, time));
        }

        PriorityQueue<TimePair> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a.time, b.time)
        );

        pq.offer(new TimePair(0, 0));

        long[] dist = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        int mod = 1_000_000_007;

        while (!pq.isEmpty()) {
            TimePair curr = pq.poll();

            int node = curr.node;
            long time = curr.time;

            if (time > dist[node]) continue;

            for (TimePair neighbor : adj.get(node)) {
                int neighborNode = neighbor.node;
                long newTime = time + neighbor.time;

                if (newTime < dist[neighborNode]) {
                    dist[neighborNode] = newTime;
                    ways[neighborNode] = ways[node];

                    pq.offer(new TimePair(neighborNode, newTime));
                }
                else if (newTime == dist[neighborNode]) {
                    ways[neighborNode] =
                            (ways[neighborNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1];
    }

    public static void main(String[] args) {
        int n = 7;

        int[][] roads = {
                {0, 6, 7},
                {0, 1, 2},
                {1, 2, 3},
                {1, 3, 3},
                {6, 3, 3},
                {3, 5, 1},
                {6, 5, 1},
                {2, 5, 1},
                {0, 4, 5},
                {4, 6, 2}
        };

        System.out.println(countPaths(n,roads));
    }
}
