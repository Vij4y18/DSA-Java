package Shortest_Path_Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetWorkDelayTime {
    private static int networkDelayTime(int[][] times, int n, int k) {
        // creating adjacency list
        List<List<TimePair>> adj = new ArrayList<>();
        for (int i=0; i<=n; i++) adj.add(new ArrayList<>());

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int wt = time[2];

            adj.get(u).add(new TimePair(v,wt));
        }

        // Dijikstas
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<TimePair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time,b.time));
        pq.offer(new TimePair(k,0));

        while (!pq.isEmpty()) {
            TimePair curr = pq.poll();
            int node = curr.node;
            Long time = curr.time;

            if (time > dist[node]) continue;

            for (TimePair it : adj.get(node)) {
                int adjNode = it.node;
                int adjTime = Math.toIntExact(it.time);
                // using TimePair because of class problem (Long & int)
                if (adjTime + time < dist[adjNode]) {
                    dist[adjNode] = Math.toIntExact(adjTime + time);
                    pq.offer(new TimePair(adjNode, adjTime + time));
                }
            }
        }
        int maxTime = -1;

        for (int i=1; i<n+1; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;

            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }

    public static void main(String[] args) {
        int[][] times = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;

        System.out.println(networkDelayTime(times,n,k));
    }
}
