package Recursion_Subsequences_Pattern;

import java.util.ArrayList;

public class PrintallSubsequences {
    static void subsequences (int[] arr, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            System.out.println(list);
            return;
        }
        // 1. TAKE
        list.add(arr[index]);
        subsequences(arr, index+1,list);

        // 2. NOT TAKE
        list.remove(list.size()-1);
        subsequences(arr, index+1, list);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ArrayList<Integer> list = new ArrayList<>();
        subsequences(arr,0,list);
    }
}
