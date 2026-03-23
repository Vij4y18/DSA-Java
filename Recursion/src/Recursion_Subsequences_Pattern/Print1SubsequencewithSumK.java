package Recursion_Subsequences_Pattern;
import java.util.ArrayList;

/*
Variation 3: Print any one subsequence with sum k
 */

public class Print1SubsequencewithSumK {
    static boolean subsequenceK (int[] arr, int index, int sum , int k, ArrayList<Integer> list) {
        if (index == arr.length) {
            if (sum == k) {
                System.out.println(list);
                return true;
            }
            return false;
        }
        // 1. TAKE

        sum += arr[index];
        list.add(arr[index]);
        if(subsequenceK(arr, index + 1, sum, k, list)) {
            return true;
        }
        // 2. NOT TAKE
        sum -= arr[index];
        list.remove(list.size()-1);
        if(subsequenceK(arr, index + 1, sum, k, list)) {
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int k = 3;
        ArrayList<Integer> list = new ArrayList<>();
        subsequenceK(arr,0,0,k,list);
    }
}
