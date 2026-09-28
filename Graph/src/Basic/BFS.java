package Basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> Q = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();

        Q.offer(0);
        visited[0] = true;

        while (!Q.isEmpty()) {
            Integer node = Q.poll();
            bfs.add(node);

            for (int it : adj.get(node)) {
                if (!visited[it]) {
                    visited[it] = true;
                    Q.offer(it);
                }
            }
        }

        return bfs;
    }

    public static void main(String[] args) {
        // Number of vertices
        int V = 5;

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(1).add(4);

        adj.get(2).add(0);

        adj.get(3).add(1);

        adj.get(4).add(1);

        // Call BFS
        ArrayList<Integer> result = bfs(adj);

        // Print result
        System.out.println(result);
    }
}
