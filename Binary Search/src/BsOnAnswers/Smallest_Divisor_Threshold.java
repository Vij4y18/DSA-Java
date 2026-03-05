package BsOnAnswers;
import java.math.*;

public class Smallest_Divisor_Threshold {
    public static int maximum(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for (int num : nums) {
            maxi = Math.max(maxi, num);
        }
        return maxi;
    }
    public static boolean divisorCheck(int[] nums, int d, int threshold) {
        int cnt = 0;
        for (int num : nums) {
            cnt += (int) Math.ceil((double) num / d);
        }
        return cnt <= threshold;
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = maximum(nums);

        while(low<=high) {
            int mid = (low+high)/2;

            if(divisorCheck(nums,mid,threshold)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    static void main() {
        int[] nums = {1,2,5,9};
        int threshold = 5;

        System.out.println(smallestDivisor(nums,threshold));
    }
}
