package Traversal_problems;
import java.util.*;

// creating a separate class because we have a lot of  sub-functions & helper functions
// https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1   problem link

class Solution {
    private final int[] delRow = {0,1,0,-1};
    private final int[] delCol = {1,0,-1,0};

    public int countDistinctIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Set<ArrayList<String>> set = new HashSet<>();
        boolean[][] vis = new boolean[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 'L' && !vis[i][j]) {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i,j,vis,grid,list,i,j);
                    set.add(list);
                }
            }
        }

        return set.size();
    }

    private void dfs (int row, int col, boolean[][] vis, char[][] grid,
                      ArrayList<String> list, int baseRow, int baseCol) {

        vis[row][col] = true;
        list.add(toString(row - baseRow, col - baseCol));

        for (int it=0; it<4; it++) {
            int i = row + delRow[it];
            int j = col + delCol[it];

            if (validCell(i,j,grid) && grid[i][j] == 'L' && !vis[i][j]) {
                dfs(i,j,vis,grid,list,baseRow, baseCol);
            }
        }
    }

    private boolean validCell (int i,int j, char[][] grid) {
        return (i>=0 && i<grid.length && j>=0 && j<grid[0].length);
    }

    private String toString (int row, int col) {
        return Integer.toString(row) + " " + Integer.toString(col);
    }
}

public class DistinctIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'L', 'L', 'W', 'L', 'L'},
                {'L', 'W', 'W', 'W', 'W'},
                {'W', 'W', 'L', 'W', 'L'},
                {'L', 'W', 'W', 'L', 'L'}
        };

        Solution ans = new Solution();
        int result = ans.countDistinctIslands(grid);
        System.out.println(result);
    }
}
