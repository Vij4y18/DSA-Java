package Easy;

/*
BRUTE ---
-> Implement rotate by one function k times to rotate the array K time

OPTIMAL ---
implemented the optimal solution where we just reverse certain index to get the answer
 */

import java.util.Arrays;

public class RotateArrayn {

    static int[] reverse (int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
        return nums;
    }

    static int[] leftrotateKPlaces (int[] nums, int k) {
        k = k % nums.length;

        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        reverse(nums,0,nums.length-1);

        return nums;
    }

    static int[] rightrotateKPlaces (int[] nums, int k) {
        k = k % nums.length;

        reverse(nums,0,k-2);
        reverse(nums,k-1,nums.length-1);
        reverse(nums,0,nums.length-1);

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int[] nums2 = {1,2,3,4,5,6,7};
        int k = 4;
        System.out.println(Arrays.toString(leftrotateKPlaces(nums, k)));
        System.out.println(Arrays.toString(rightrotateKPlaces(nums2, k)));

    }
}
