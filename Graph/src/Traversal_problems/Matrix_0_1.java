package Traversal_problems;

import java.util.LinkedList;
import java.util.Queue;

class Pairs {
    int row;
    int col;
    int dist;

    Pairs (int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

public class Matrix_0_1 {
    public static void main(String[] args) {
        int[][] mat = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };

        int[][] ans = updateMatrix(mat);

        for (int[] row : ans) {
            for (int col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] distance = new int[n][m];

        Queue<Pairs> que = new LinkedList<>();

        for (int i=0; i<n; i++) {
            for(int j=0; j<m; j++){
                if (mat[i][j] == 0) {
                    que.offer(new Pairs(i,j,0));
                    vis[i][j] = true;
                }
            }
        }

        // creating delta row and col for accessing neighbours
        int[] delRow = {0,1,0,-1};
        int[] delCol = {-1,0,1,0};

        while (!que.isEmpty()) {
            Pairs curr = que.poll();

            int row = curr.row;
            int col = curr.col;
            int dist = curr.dist;

            distance[row][col] = dist;

            for (int i=0; i<4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if (nRow >= 0 && nRow < mat.length && nCol >= 0 && nCol < mat[0].length && !vis[nRow][nCol] && mat[nRow][nCol] == 1) {
                    que.offer(new Pairs(nRow,nCol,dist+1));
                    vis[nRow][nCol] = true;
                }
            }
        }
        return distance;
    }
}
