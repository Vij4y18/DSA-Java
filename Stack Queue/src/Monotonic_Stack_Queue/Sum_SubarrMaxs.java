package Monotonic_Stack_Queue;

import java.util.Stack;

public class Sum_SubarrMaxs {

    static int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    static int[] findPGEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    public static int sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int mod = (int)1e9 + 7;

        int[] nge = findNGE(arr);
        int[] pgee = findPGEE(arr);

        long sum = 0;  // FIX: use long

        for (int i = 0; i < n; i++) {
            int left = i - pgee[i];
            int right = nge[i] - i;

            long contrib = (long) arr[i] * left * right;
            sum = (sum + contrib) % mod;
        }

        return (int) sum;
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5};

        System.out.println(sumSubarrayMaxs(arr));
    }
}
