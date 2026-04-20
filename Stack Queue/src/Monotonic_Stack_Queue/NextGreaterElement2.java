package Monotonic_Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {

    static int[] optimalNGE2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i=2*(n-1);i>=0;i--) {
            while (!st.isEmpty() && nums[i%n] >= st.peek()) st.pop();

            if (i < n) {
                int NGE = st.isEmpty() ? -1 : st.peek();
                ans[i] = NGE;
            }

            st.push(nums[i%n]);
        }

        return ans;
    }

    static int[] bruteNGE2 (int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i=0;i<n;i++) {
            for (int j=i+1;j<i+n;j++) {
                int indx = j%n;
                if (nums[indx] > nums[i]) {
                    ans[i] = nums[indx];
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1};
        System.out.println(Arrays.toString(bruteNGE2(arr)));
        System.out.println(Arrays.toString(optimalNGE2(arr)));
    }
}
