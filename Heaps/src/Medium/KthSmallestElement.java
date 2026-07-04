package Medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

    static int findKthSmallest (int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap

        for (int i=0; i<nums.length; i++) {
            if (maxHeap.size() < k) {
                maxHeap.offer(nums[i]);
            } else if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {5,6,3,1,4,2};
        int k = 2;

        System.out.println(findKthSmallest(nums, k));
    }
}
