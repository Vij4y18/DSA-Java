package Monotonic_Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    static int[] optimalNGE(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];

        for (int i=arr.length-1;i>=0;i--) {
            while ((!st.isEmpty()) && (arr[i] >= st.peek())) st.pop();

            if (st.isEmpty()) res[i] = -1;
            else res[i] = st.peek();

            st.push(arr[i]);
        }

        return res;
    }

    static int[] bruteNGE(int[] arr) {
        int[] ans = new int[arr.length];

        for (int i=0;i<arr.length;i++) {
            for (int j=i;j<arr.length;j++) {
                if (arr[j] > arr[i]) {
                    ans[i] = arr[j];
                    break;
                }
            }
            if (ans[i] == 0) ans[i] = -1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {6,8,0,1,3};
        System.out.println(Arrays.toString(bruteNGE(arr)));
        System.out.println(Arrays.toString(optimalNGE(arr)));
    }
}
