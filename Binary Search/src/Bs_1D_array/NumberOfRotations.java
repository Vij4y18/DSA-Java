package Bs_1D_array;

public class NumberOfRotations {
    public static int nor(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int ans = Integer.MAX_VALUE;
        int indx = -1;

        while(low<=high) {
            int mid = (low+high)/2;

            if(nums[low]<=nums[mid]) {
                if (ans > nums[low]){
                    ans = nums[low];
                    indx = low;
                }
                low = mid + 1;
            } else {
                if (ans > nums[mid]){
                    ans = nums[mid];
                    indx = mid;
                }
                high = mid - 1;
            }
        }
        return indx;
    }
    static void main() {
        int[] nums = {3,4,5,1,2};

        System.out.println(nor(nums));
    }
}
