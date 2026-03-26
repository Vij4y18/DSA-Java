package Recursion_Subsequences_Pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {
    static void subsets(int[] arr, int index,List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));

        for(int i=index; i<arr.length; i++) {
            if (i > index && arr[i] == arr[i-1]) continue;
            list.add(arr[i]);
            subsets(arr,i+1,res,list);
            list.remove(list.size()-1);
        }
    }
    static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums,0,res,new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        int []arr = {1,2,3};
        System.out.println(subsetsWithDup(arr));
    }
}
