package Shortest_Path_Algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

class Data {
    int row;
    int col;
    int effort;

    Data (int row, int col, int effort) {
        this.row = row;
        this.col = col;
        this.effort = effort;
    }
}

public class PathMinEffort {
    private static boolean isValid (int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    private static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Data> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.effort,b.effort));
        int[][] dist = new int[n][m];
        for(int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = heights[0][0];
        pq.offer(new Data(0,0,0));
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            Data curr = pq.poll();
            int row = curr.row;
            int col = curr.col;
            int currEffort = curr.effort;

            if (row == n-1 && col == m-1) return currEffort;

            for (int i=0; i<4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if (isValid(nRow,nCol,n,m)) {
                    int newEffort = Math.max(currEffort,
                            Math.abs(heights[row][col] - heights[nRow][nCol]));

                    if (newEffort < dist[nRow][nCol]) {
                        dist[nRow][nCol] = newEffort;
                        pq.offer(new Data(nRow,nCol,newEffort));
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] heights = {
                {1,2,2},
                {3,8,2},
                {5,3,5}
        };

        System.out.println(minimumEffortPath(heights));
    }
}
