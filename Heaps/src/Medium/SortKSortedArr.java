package Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArr {

    static int[] sortKSortedArray (int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;

        for (int i=0; i<nums.length; i++) {
            if (heap.size() < k+1) {
                heap.offer(nums[i]);
            } else {
                nums[index] = heap.poll();
                heap.offer(nums[i]);
                index++;
            }
        }

        while (!heap.isEmpty()) {
            nums[index] = heap.poll();;

            index++;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;

        System.out.println(Arrays.toString(sortKSortedArray(nums, k)));
    }
}
