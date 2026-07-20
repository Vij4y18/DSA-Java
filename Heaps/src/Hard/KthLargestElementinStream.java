package Hard;

import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.k = k;

        for (int i=0; i<nums.length; i++) {
            if (heap.size() < k) {
                heap.offer(nums[i]);
            } else if (nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
    }

    public int add(int val) {

        if (heap.size() < k) {
            heap.offer(val);
        } else if (val > heap.peek()) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
}

public class KthLargestElementinStream {
    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};

        KthLargest kthLargest = new KthLargest(3, nums);

        System.out.println(kthLargest.add(3));   // 4
        System.out.println(kthLargest.add(5));   // 5
        System.out.println(kthLargest.add(10));  // 5
        System.out.println(kthLargest.add(9));   // 8
        System.out.println(kthLargest.add(4));   // 8

    }
}
