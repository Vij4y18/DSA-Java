package Recursion_Subsequences_Pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_II {
    static void findCombinations(int[] arr,int index,int target, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations(arr, i + 1, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
    public static List<List<Integer>> combinationSumII(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates,0,target,ans,new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSumII(arr,target));
    }
}
