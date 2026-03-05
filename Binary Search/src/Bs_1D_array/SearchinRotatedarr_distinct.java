package Bs_1D_array;

public class SearchinRotatedarr_distinct {
    public static int bs(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high) {
            int mid = (low+high)/2;

            if(nums[mid] == target) {
                return mid;
            }
            if(nums[low] < nums[mid]-1) {
                if(target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(target >= nums[mid]+1 && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    static void main() {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 6;

        System.out.println(bs(nums,target));
    }
}
