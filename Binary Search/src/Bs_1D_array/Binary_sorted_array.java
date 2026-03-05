package Bs_1D_array;

public class Binary_sorted_array {
    public static int binary(int[] nums, int n, int target) {
        int low = 0;
        int high = n-1;

        while(low<=high) {
            int mid = (low+high)/2;

            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    static void main() {
        int[] arr = {2,3,5,7,8,10};
        int target = 12;
        int n = arr.length;

        System.out.println(binary(arr,n,target));
    }
}
