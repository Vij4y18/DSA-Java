package Monotonic_Stack_Queue;

import java.util.*;

class Solution {

    // Next Smaller Element (strictly smaller on right)
    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    // Previous Smaller or Equal Element
    private int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int)1e9 + 7;

        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);

        long sum = 0;  // FIX: use long

        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;

            long contrib = (long) arr[i] * left * right;
            sum = (sum + contrib) % mod;
        }

        return (int) sum;
    }
}

public class Sum_SubarrMins {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5};

        Solution sol = new Solution();
        int ans = sol.sumSubarrayMins(arr);

        System.out.println("The sum of minimum value in each subarray is: " + ans);
    }
}