package ImplmentaionProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i<=nums.length-k; i++) {
            int maxi = nums[i];
            for (int j=i; j<i+k; j++) {
                maxi = Math.max(maxi,nums[j]);
            }
            list.add(maxi);
        }

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i); // Auto-unboxing converts Integer to int
        }

        return array;
    }

    static int[] maxSlidingWindowOptimal(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] ans = new int[nums.length-k+1];
        int index = 0;

        for (int i=0; i<nums.length; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i-k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);

            if (i >= k-1) {
                ans[index++] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindowOptimal(nums,k)));
    }
}
