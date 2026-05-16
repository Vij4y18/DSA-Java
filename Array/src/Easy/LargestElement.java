package Easy;

import java.util.Arrays;

public class LargestElement {
    static int brute (int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length-1];
    }

    static int optimal (int[] nums) {
        int maxi = 0; // Considering array only contains positives if not use INT_MIN

        for (int i=0; i<nums.length; i++) {
            maxi = Math.max(nums[i],maxi);
        }

        return maxi;
    }
    public static void main(String[] args) {
        int[] arr = {4,3,7,5,1};
        System.out.println(optimal(arr));
    }
}
