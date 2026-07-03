package Medium;

import java.util.PriorityQueue;

/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */

public class KthLargestElement {

    static int findKthLargest (int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i=0; i<nums.length; i++) {
            if (heap.size() < k) {
                heap.offer(nums[i]);
            } else if (nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }

        return heap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        System.out.println(findKthLargest(nums, k));
    }
}
