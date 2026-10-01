package Traversal_problems;

public class NumberofIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(countIslands(grid));
    }

    static int countIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int island = 0;
        boolean[][] vis = new boolean[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    dfs(i, j, vis, grid);
                    island++;
                }
            }
        }

        return island;
    }

    private static void dfs (int row, int col, boolean[][] vis, char[][] grid) {
        vis[row][col] = true;

        int rowStart = row > 0 ? row-1 : row;
        int rowEnd = row < grid.length-1 ? row+1 : row;
        int colStart = col > 0 ? col-1 : col;
        int colEnd = col < grid[0].length-1 ? col+1 : col;

        for (int i=rowStart; i<=rowEnd; i++) {
            for (int j=colStart; j<=colEnd; j++) {
                // skip diagonals for leetcode, for gfg you need to check diagonal as well so don't need this
                if (i != row && j != col) continue;   // avoiding diagonals

                if (!vis[i][j] && grid[i][j] == '1') {
                    dfs (i, j, vis, grid);
                }
            }
        }
    }
}
