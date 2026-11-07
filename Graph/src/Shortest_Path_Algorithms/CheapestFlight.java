package Shortest_Path_Algorithms;
import java.util.*;

class flight {
    int node;
    int cost;
    int steps;

    flight (int node, int cost, int steps) {
        this.node = node;
        this.cost = cost;
        this.steps = steps;
    }

    flight (int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

public class CheapestFlight {
    private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(src==dst)
            return 0;
        // creating adj list
        List<List<flight>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            adj.get(from).add(new flight(to, price));
        }

        Queue<flight> q = new LinkedList<>();
        q.offer(new flight(src,0,0));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!q.isEmpty()) {
            flight curr = q.poll();
            int currNode = curr.node;
            int currCost = curr.cost;
            int steps = curr.steps;

            if (steps > k) continue;

            for (flight neighbor : adj.get(currNode)) {
                int neighborNode = neighbor.node;
                int neighborCost = neighbor.cost;

                int newStep = steps + 1;
                int newCost = currCost + neighborCost;

                if (newStep <= k+1 && dist[neighborNode] >= newCost) {
                    dist[neighborNode] = newCost;
                    q.offer(new flight(neighborNode,newCost,newStep));
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };

        int src = 0;
        int dst = 3;
        int k = 1;

        System.out.println(findCheapestPrice(n,flights,src,dst,k));
    }
}
