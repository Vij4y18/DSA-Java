package Bs_1D_array;

public class Floor_ceil {
    public static int floor(int[] nums, int x) {
        int low = 0;
        int high = nums.length-1;
        int ans = -1;

        while(low<=high) {
            int mid = (low+high)/2;

            if(nums[mid] <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static int ceil(int[] nums, int x) {
        int low = 0;
        int high = nums.length-1;
        int ans = -1;

        while(low<=high) {
            int mid = (low+high)/2;

            if(nums[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    static void main() {
        int[] nums = {3,4,4,7,8,10};
        int x = 5;

        System.out.println(floor(nums,x));
        System.out.println(ceil(nums,x));
    }
}
