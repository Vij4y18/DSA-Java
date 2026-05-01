package Monotonic_Stack_Queue;

import java.util.Stack;

public class MaximalRectangle {
    static int largestRectangleArea(int[] heights) {
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

    static int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            int currArea = largestRectangleArea(heights);
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle(matrix));
    }
}
