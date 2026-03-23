package Recursion_Subsequences_Pattern;

import java.util.ArrayList;

public class GenerateParenthesis {
    static void backTrack (ArrayList<String> res, int left, int right, String s, int n) {
        if (s.length() == n*2) {
            res.add(s);
            return;
        }
        if(left < n) {
            backTrack(res,left+1,right,s+"(",n);
        }
        if (right < left) {
            backTrack(res,left,right+1,s+")",n);
        }
    }
    static ArrayList<String> parenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        backTrack(res,0,0,"",n);
        return res;
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(parenthesis(n));
    }
}
