package Recursion_Hard;

import java.util.ArrayList;

public class RatinMaze {
    static void escapeMaze (int i, int j, int[][] arr, String s,ArrayList<String> res, int n) {
        if (i == n-1 && j == n-1) {
            res.add(s);
            return;
        }

        // Mark Visited location
        arr[i][j] = 0;

        if (i+1 < n && arr[i+1][j] == 1) escapeMaze(i+1,j,arr,s+"D",res,n);
        if (j-1 >= 0 && arr[i][j-1] == 1) escapeMaze(i,j-1,arr,s+"L",res,n);
        if (j+1 < n && arr[i][j+1] == 1) escapeMaze(i,j+1,arr,s+"R",res,n);
        if (i-1 >= 0 && arr[i-1][j] == 1) escapeMaze(i-1,j,arr,s+"U",res,n);

        arr[i][j] = 1;
    }

    static ArrayList<String> ratInMaze (int[][] maze) {
        ArrayList<String> res = new ArrayList<>();
        escapeMaze(0,0,maze,"",res,maze.length);
        return res;
    }
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        // int[][] maze = {{1,0},{1,0}};  Invalid path check
        System.out.println(ratInMaze(maze));
    }
}
