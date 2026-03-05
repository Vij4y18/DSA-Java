package Bs_1D_array;

public class Upper_bound {
    public static int upperbound(int[] nums, int x) {
        int low = 0;
        int high = nums.length-1;
        int ans = nums.length;

        while(low<=high) {
            int mid = (low+high)/2;

            if(nums[mid] > x) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int x = 3;

        System.out.println(upperbound(arr,x));
    }
}
