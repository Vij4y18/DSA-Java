package Minimum_Spanning_Tree;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair {
    int node;
    int parent;
    int wt;

    Pair(int node, int parent, int wt) {
        this.node = node;
        this.parent = parent;
        this.wt = wt;
    }
}

public class PrimsAlgo {
    private static int primMST(ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int V = adj.size();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.wt,b.wt));
        int[] vis = new int[V];
        int totalWeight = 0;
        pq.offer(new Pair(0,-1,0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (vis[curr.node] == 1) continue;

            vis[curr.node] = 1;
            totalWeight += curr.wt;

            for (ArrayList<Integer> neighbor : adj.get(curr.node)) {
                int adjNode = neighbor.get(0);
                int edgeWt = neighbor.get(1);

                pq.offer(new Pair(adjNode,curr.node,edgeWt));
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        int[][][] edges = {
                {{1, 5}, {2, 1}},
                {{0, 5}, {2, 3}},
                {{0, 1}, {1, 3}}
        };

        for (int i = 0; i < edges.length; i++) {
            ArrayList<ArrayList<Integer>> neighbours = new ArrayList<>();

            for (int j = 0; j < edges[i].length; j++) {
                ArrayList<Integer> edge = new ArrayList<>();

                edge.add(edges[i][j][0]); // neighbour
                edge.add(edges[i][j][1]); // weight

                neighbours.add(edge);
            }

            adj.add(neighbours);
        }

        System.out.println(primMST(adj));
    }
}
