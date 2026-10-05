package Traversal_problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Cell {
    int row;
    int col;

    Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };


        solve(board);

        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Cell> que = new LinkedList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if ((i==0 || i==n-1 || j==0 || j==m-1) && board[i][j] == 'O') {
                    que.offer(new Cell(i,j));
                    vis[i][j] = true;
                }
            }
        }
        //  creating 4 directions for traversl
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while (!que.isEmpty()) {
            int row = que.peek().row;
            int col = que.peek().col;
            que.poll();

            for (int i=0; i<4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if (nRow>=0 && nRow<n && nCol>=0 && nCol<m &&
                        board[nRow][nCol]=='O' && !vis[nRow][nCol]){
                    vis[nRow][nCol] = true;
                    que.offer(new Cell(nRow, nCol));
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
