package Monotonic_Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class PrevSmallElement {

    static int[] PSE (int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i=0; i<n; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i]) st.pop();

            ans[i] = st.isEmpty() ? -1 : st.peek();

            st.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,2,10,8};

        System.out.println(Arrays.toString(PSE(arr)));
    }
}
