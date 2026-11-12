package Shortest_Path_Algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

class Matrix {
    int row;
    int col;
    int time;

    Matrix(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class Swim_Rising_water {
    private static int swimInWater(int[][] grid) {
        int n = grid.length;

        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Matrix> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.time, b.time)
        );

        dist[0][0] = grid[0][0];
        pq.offer(new Matrix(0, 0, grid[0][0]));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            Matrix curr = pq.poll();

            int row = curr.row;
            int col = curr.col;
            int time = curr.time;

            // Ignore outdated entries
            if (time > dist[row][col]) continue;

            // Destination reached
            if (row == n - 1 && col == n - 1) {
                return time;
            }

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {

                    int newTime = Math.max(time, grid[nr][nc]);

                    if (newTime < dist[nr][nc]) {
                        dist[nr][nc] = newTime;
                        pq.offer(new Matrix(nr, nc, newTime));
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        };

        System.out.println(swimInWater(grid));
    }
}
