package Bs_1D_array;

import static java.lang.Math.min;

public class Min_in_Rotatedsortedarr {
    public static int minvalue(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        int mini = Integer.MAX_VALUE;

        while(low<=high) {
            int mid = (low+high)/2;

            if(nums[low] <= nums[mid]) {
                mini = min(mini, nums[low]);
                low = mid+1;
            } else {
                mini = min(mini, nums[mid]);
                high = mid-1;
            }
        }
        return mini;
    }
    static void main() {
        int[] nums = {6,7,1,2,3};

        System.out.println(minvalue(nums));
    }
}
