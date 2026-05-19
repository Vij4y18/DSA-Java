package Easy;

import java.util.Arrays;

public class RotateArray1 {

    static int[] leftRotate (int[] nums) {
        int temp = nums[0];

        for (int i=0; i<nums.length-1; i++) {
            nums[i] = nums[i+1];
        }
        nums[nums.length-1] = temp;

        return nums;
    }

    static int[] rightRotate (int[] nums) {
        int temp = nums[nums.length-1];

        for (int i=nums.length-1; i>0; i--) {
            nums[i] = nums[i-1];
        }
        nums[0] = temp;

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] nums2 = {1,2,3,4,5};

        System.out.println(Arrays.toString(leftRotate(nums)));
        System.out.println();
        System.out.println(Arrays.toString(rightRotate(nums2)));
    }
}
