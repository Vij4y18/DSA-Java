package Bs_1D_array;

public class SearchinRotatedarr_duplicates {
    public static boolean bs(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high) {
            int mid = (low+high)/2;

            if(nums[mid] == target) {
                return true;
            }
            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low+=1;
                high-=1;
            }
            if(nums[low] < nums[mid]) {
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
        return false;
    }
    static void main() {
        int[] nums = {3,1,2,3,3,3,3};
        int target = 2;

        System.out.println(bs(nums,target));
    }
}
