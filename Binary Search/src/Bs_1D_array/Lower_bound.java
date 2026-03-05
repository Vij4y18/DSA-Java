package Bs_1D_array;

public class Lower_bound {
    public static int lowerbound(int[] nums, int x) {
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
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 7, 8, 9, 9, 9, 11};
        int x = 9;
        System.out.println(lowerbound(arr,x));
    }
}
