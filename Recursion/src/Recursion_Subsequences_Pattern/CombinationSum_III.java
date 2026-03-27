package Recursion_Subsequences_Pattern;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_III {
    static void combinationSumIII(int start,int target, int k, List<List<Integer>> res, List<Integer> ds){
        if (target == 0 && ds.size() == k) {
            res.add(new ArrayList<>(ds));
            return;
        }

        if (target < 0 || ds.size() > k) return;

        for (int i = start; i<=9; i++) {
            ds.add(i);
            combinationSumIII(i+1,target-i,k,res,ds);
            ds.remove(ds.size()-1);
        }
    }
    static List<List<Integer>> combinationSum3 (int target, int k) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        combinationSumIII(1,target,k,res,new ArrayList<>());
        return res;
    }
    public static void main(String[] args) {
        int target = 7;
        int k = 3;
        System.out.println(combinationSum3(target,k));

    }
}
