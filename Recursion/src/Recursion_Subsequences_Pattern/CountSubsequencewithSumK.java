package Recursion_Subsequences_Pattern;

import java.util.ArrayList;

/*
Variation 2: count of all the subsequence with sum k
 */
public class CountSubsequencewithSumK {
    static int subsequenceK (int[] arr, int index, int sum , int k, ArrayList<Integer> list) {
        if (index == arr.length) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }
        // 1. TAKE

        sum += arr[index];
        int l = subsequenceK(arr, index+1,sum, k,list);
        // 2. NOT TAKE
        sum -= arr[index];
        int r = subsequenceK(arr, index+1,sum, k,list);

        return l+r;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int k = 3;
        ArrayList<Integer> list = new ArrayList<>();
        int res = subsequenceK(arr,0,0,k,list);
        System.out.println(res);
    }
}
