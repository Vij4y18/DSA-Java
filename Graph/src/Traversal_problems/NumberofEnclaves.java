package Traversal_problems;

public class NumberofEnclaves {
    public static void main(String[] args) {
        int[][] grid = {
            {0,0,0,0},
            {1,0,1,0},
            {0,1,1,0},
            {0,0,0,0}
        };

        System.out.println(numEnclaves(grid));
    }

    static boolean isBoundary(int row, int col, int n, int m) {
        return row == 0 || row == n - 1 || col == 0 || col == m - 1;
    }

    static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m  = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;

        // marking the boundry cell which has 1 and connected to other 1's
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (isBoundary(i,j,n,m) && grid[i][j] == 1 && !vis[i][j]) {
                    dfs(i, j, vis, grid);
                }
            }
        }

        for (int i=1; i<n-1; i++) {
            for(int j=1; j<m-1; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static void dfs (int row, int col, boolean[][] vis, int[][] grid) {
        vis[row][col] = true;

        int rowStart = row > 0 ? row-1 : row;
        int rowEnd = row < grid.length-1 ? row+1 : row;
        int colStart = col > 0 ? col-1 : col;
        int colEnd = col < grid[0].length-1 ? col+1 : col;

        for (int i=rowStart; i<=rowEnd; i++) {
            for (int j=colStart; j<=colEnd; j++) {
                // skip diagonals
                if (i != row && j != col) continue;

                if (grid[i][j] == 1 && !vis[i][j]) {
                    dfs (i, j, vis, grid);
                }
            }
        }
    }
}
