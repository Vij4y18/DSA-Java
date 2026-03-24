package Recursion_Subsequences_Pattern;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_I {
    public static void findCombinations(int[] arr,int index,int target, List<List<Integer>> ans, List<Integer> ds) {
        if (index == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[index] <= target) {
            ds.add(arr[index]);
            findCombinations(arr,index,target-arr[index],ans,ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(arr,index+1,target,ans,ds);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(candidates,0,target,ans,new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(arr,target));
    }
}
