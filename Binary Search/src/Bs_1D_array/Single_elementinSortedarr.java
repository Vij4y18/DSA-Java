package Bs_1D_array;

public class Single_elementinSortedarr {
    public static int singlee(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(nums[0] != nums[1]) {
            return nums[0];
        }
        if(nums[n-1] != nums[n-2]) {
            return nums[n-1];
        }

        int low = 1;
        int high = n-2;

        while(low<=high) {
            int mid = (low+high)/2;

            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }
            if ((mid%2 == 1 && nums[mid-1] == nums[mid]) || (mid%2 == 0 && nums[mid+1] == nums[mid])) {
                low+=1;
            } else {
                high-=1;
            }
        }
        return -1;
    }
    static void main() {
        int[] nums = {1,1,2,2,3,3,4,5,5,6,6};
        System.out.println(singlee(nums));
    }
}
