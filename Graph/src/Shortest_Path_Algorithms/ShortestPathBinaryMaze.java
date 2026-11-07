package Shortest_Path_Algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class RowCol {
    int row;
    int col;

    RowCol (int row, int col) {
        this.row = row;
        this.col = col;
    }
}
public class ShortestPathBinaryMaze {
    private static boolean isValid (int row, int col, int length) {
        return row >= 0 && row < length && col >= 0 && col < length;
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        Queue<RowCol> q = new LinkedList<>();
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 1;
        q.offer(new RowCol(0,0));

        int[] delRow = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] delCol = {0, 1, 1, 1, 0, -1, -1, -1};

        while (!q.isEmpty()) {
            RowCol curr = q.poll();
            int row = curr.row;
            int col = curr.col;

            for (int i=0; i<8; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if (isValid(nRow,nCol,n) && grid[nRow][nCol] == 0 && dist[nRow][nCol] == Integer.MAX_VALUE) {
                    if (nRow == n-1 && nCol == n-1) return dist[row][col]+1;
                    q.offer(new RowCol(nRow,nCol));
                    dist[nRow][nCol] = dist[row][col] + 1;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {0,0,0},
            {1,1,0},
            {1,1,0}
        };

        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
