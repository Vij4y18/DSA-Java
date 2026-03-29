package Recursion_Hard;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class NQueen {
    static void recurse (int col, char[][] board, List<List<String>> res, int[] left, int[] upperdiagonal, int[] lowerdiagonal, int n) {
        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            res.add(temp);
        }

        for (int row = 0;row<n;row++) {
            if (left[row] == 0 && upperdiagonal[n-1+col-row] == 0 && lowerdiagonal[row+col] == 0){
                // 1. add Queen
                board[row][col] = 'Q';

                // 2. Mark Position
                left[row] = 1;
                upperdiagonal[n-1+col-row] = 1;
                lowerdiagonal[col+row] = 1;

                // 3. Recurse
                recurse(col+1,board,res,left,upperdiagonal,lowerdiagonal,n);

                // 4. BackTrack
                board[row][col] = '.';
                left[row] = 0;
                upperdiagonal[n-1+col-row] = 0;
                lowerdiagonal[col+row] = 0;
            }
        }
    }
    static List<List<String>> nQueen (int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        int[] left = new int[n];
        int[] upperdiagonal = new int[n*2-1];
        int[] lowerdiagonal = new int[n*2-1];

        recurse(0,board,res,left,upperdiagonal,lowerdiagonal,n);

        return res;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(nQueen(n));
    }
}
