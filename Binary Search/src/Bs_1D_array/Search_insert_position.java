package Bs_1D_array;

public class Search_insert_position {
    public static int sip(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = 0;

        while(low<=high) {
            int mid = (low+high)/2;
            ans = mid;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans+1;
    }

    static void main(String[] args) {
        int[] arr = {2,3,4,6,7,8,19};
        int target = 10;

        System.out.println(sip(arr,target));
    }
}
