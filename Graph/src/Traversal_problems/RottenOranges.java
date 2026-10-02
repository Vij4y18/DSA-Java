package Traversal_problems;
import java.util.*;

class Pair {
    int row;
    int col;
    int time;

    Pair (int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        System.out.println(orangesRotting(grid));
    }

    static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<Pair> que = new LinkedList<>();
        int maxTime = 0;

        // Pushing the initial rotten oranges into QUEUE
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 2) {
                    que.offer(new Pair(i,j,0));
                }
            }
        }

        // creating delta row and col for accessing neighbours
        int[] delRow = {0,1,0,-1};
        int[] delCol = {-1,0,1,0};

        // BFS
        while (!que.isEmpty()) {
            Pair curr = que.poll();
            int row = curr.row;
            int col = curr.col;
            int time = curr.time;

            if (time > maxTime) maxTime = time;

            for (int i=0; i<4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !vis[nRow][nCol] && grid[nRow][nCol] == 1) {
                    vis[nRow][nCol] = true;
                    que.offer(new Pair(nRow,nCol,time+1));
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    return -1;
                }
            }
        }

        return maxTime;
    }
}
