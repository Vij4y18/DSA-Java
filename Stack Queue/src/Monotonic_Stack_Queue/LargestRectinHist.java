package Monotonic_Stack_Queue;

import java.util.Stack;

class Solution {

    public int[] NSE (int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];

        for (int i=arr.length-1; i>=0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();

            res[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return res;
    }

    public int[] PSE (int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];

        for (int i=0; i<arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();

            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int[] pse = PSE(heights);
        int[] nse = NSE(heights);
        int maxArea = 0;

        for(int i=0; i<heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (nse[i] - pse[i] - 1));
        }
        return maxArea;
    }
}

public class LargestRectinHist {

    static int largestRectangleAreaOptimal(int[] heights) {
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int element = heights[st.pop()];
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                maxArea = Math.max(maxArea, element*(nse-pse-1));
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int element = heights[st.pop()];
            int nse = heights.length;
            int pse = st.isEmpty() ? -1 : st.peek();

            maxArea = Math.max(maxArea, element*(nse-pse-1));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // Solution obj = new Solution();
        int[] heights = {2,1,5,6,2,3};

        // int ans = obj.largestRectangleArea(heights);
        System.out.println(largestRectangleAreaOptimal(heights));
    }
}
