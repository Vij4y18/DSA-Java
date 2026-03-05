package Bs_1D_array;

public class PeakElementinarr {
    public static int peak(int[] nums) {
        int n = nums.length;

        if(n==1) {
            return nums[0];
        }
        if(nums[0] > nums[1]) {
            return nums[0];
        }
        if(nums[n-1] > nums[n-2]) {
            return nums[0];
        }

        int low = 1;
        int high = n-2;

        while(low<=high) {
            int mid = (low+high)/2;

            if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) {
                return nums[mid];
            } else if (nums[mid+1] > nums[mid]) {
                low+=1;
            } else {
                high-=1;
            }
        }
        return -1;
    }
    static void main() {
        int[] nums = {1,2,3,4,2,3,5,3};

        System.out.println(peak(nums));
    }
}
