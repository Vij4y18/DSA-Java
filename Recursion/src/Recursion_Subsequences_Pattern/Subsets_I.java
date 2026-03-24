package Recursion_Subsequences_Pattern;
import java.util.*;

public class Subsets_I {
    static void findset (int[] arr, int index, List<List<Integer>> res, List<Integer> ds) {
        if (index == arr.length) {
            res.add(new ArrayList<>(ds));
            return;
        }

        // PICK
        ds.add(arr[index]);
        findset(arr,index+1,res,ds);

        // NOT PICK
        ds.remove(ds.size()-1);
        findset(arr,index+1,res,ds);
    }
    static List<List<Integer>> subsetsI (int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        findset(arr,0,res,new ArrayList<>());
        return res;
    }
    public static void main(String[] args) {
        int []arr = {1,2,3};
        System.out.println(subsetsI(arr));
    }
}
