package Monotonic_Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i=0; i<asteroids.length; i++) {
            if (asteroids[i] > 0) {
                st.push(asteroids[i]);
            } else {
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])) st.pop();
                if (!st.isEmpty() && st.peek() == Math.abs(asteroids[i])) {
                    st.pop();
                } else if(st.isEmpty() || st.peek() < 0) {
                    st.push(asteroids[i]);
                }
            }
        }

        int[] ans = new int[st.size()];

        for (int i = 0; i < st.size(); i++) {
            ans[i] = st.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,-6,2,-1,4};

        System.out.println(Arrays.toString(asteroidCollision(arr)));
    }
}
