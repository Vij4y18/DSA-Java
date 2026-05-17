package Easy;

/*
Brute Approach is to use Set Data Structure to filter unique elements
then traverse the set DS and store the elements into array
 */

import java.util.Arrays;

public class RemoveDuplicates {
    static int[] removeDuplicates (int[] nums) {
        int ptr = 0;

        for (int i=1; i<nums.length; i++) {
            if (nums[ptr] != nums[i]) {
                ptr++;
                nums[ptr] = nums[i];
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,3,3};
        System.out.println(Arrays.toString(removeDuplicates(nums)));
    }
}
