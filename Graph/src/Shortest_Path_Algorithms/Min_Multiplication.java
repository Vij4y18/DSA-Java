package Shortest_Path_Algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Min_Multiplication {
    private static int minSteps(int[] arr, int start, int end) {
        if (start == end) return 0;
        int n = arr.length;
        int mod = 1000;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair (start,0));
        int[] dist = new int[1000];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int node = curr.node;
            int step = curr.distance;

            for (int i=0; i<n; i++) {
                int num = (arr[i] * node) % mod;
                if (step+1 < dist[num]) {
                    dist[num] = step+1;
                    if (num == end) return step+1;
                    q.offer(new Pair(num, step+1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 65};
        int start = 7;
        int end = 175;

        System.out.println(minSteps(arr,start,end));
    }
}
