package Bs_1D_array;

public class Count_occurance {
    public static int first_ocr(int[] nums, int x) {
        int low = 0;
        int high = nums.length-1;
        int ans = -1;

        while(low<=high) {
            int mid = (low+high)/2;

            if(nums[mid] == x) {
                ans = mid;
                high = mid - 1;
            } else if (nums[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int last_ocr(int[] nums, int x) {
        int low = 0;
        int high = nums.length-1;
        int ans = -1;

        while(low<=high) {
            int mid = (low+high)/2;

            if(nums[mid] == x) {
                ans = mid;
                low = mid +1;
            } else if (nums[mid] > x) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    static void main() {
        int[] nums = {3,4,13,13,13,13,20,40};
        int x = 13;

        int first = first_ocr(nums,x);
        int last = last_ocr(nums,x);

        System.out.println(last-first + 1);
    }
}
