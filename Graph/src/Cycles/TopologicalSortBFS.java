package Cycles;


// Kahn' Algorithm https://takeuforward.org/practice/dsa/topological-sort-or-kahns-algorithm

import java.util.*;

public class TopologicalSortBFS {
    private static int[] topoSort(int V, List<List<Integer>> adj) {
        int[] result = new int[V];
        int[] inDegree = new int[V];
        Queue<Integer> q = new LinkedList<>();

        for (List<Integer> list : adj) {
            for (Integer val : list) {
                inDegree[val]++;
            }
        }

        for (int i=0; i<V; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int index = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            result[index++] = curr;

            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int V = 6;

        List<List<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(Arrays.asList()));
        adj.add(new ArrayList<>(Arrays.asList()));
        adj.add(new ArrayList<>(Arrays.asList(3)));
        adj.add(new ArrayList<>(Arrays.asList(1)));
        adj.add(new ArrayList<>(Arrays.asList(0, 1)));
        adj.add(new ArrayList<>(Arrays.asList(2, 0)));

        int[] result = topoSort(V, adj);

        System.out.println(Arrays.toString(result));
    }
}
