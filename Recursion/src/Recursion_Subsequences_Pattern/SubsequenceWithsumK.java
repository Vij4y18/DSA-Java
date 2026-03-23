package Recursion_Subsequences_Pattern;

import java.util.ArrayList;

/*
Variation 1: print all the subsequence with sum k
 */


public class SubsequenceWithsumK {
    static void subsequenceK (int[] arr, int index, int sum , int k, ArrayList<Integer> list) {
        if (index == arr.length) {
            if (sum == k) {
                System.out.println(list);
            }
            return;
        }
        // 1. TAKE
        list.add(arr[index]);
        sum += arr[index];
        subsequenceK(arr, index+1,sum, k,list);
        // 2. NOT TAKE
        list.remove(list.size()-1);
        sum -= arr[index];
        subsequenceK(arr, index+1,sum, k,list);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int k = 3;
        ArrayList<Integer> list = new ArrayList<>();
        subsequenceK(arr,0,0,k,list);
    }
}
