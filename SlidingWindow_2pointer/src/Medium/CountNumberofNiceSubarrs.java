package Medium;

public class CountNumberofNiceSubarrs {

    static int atMost (int[] nums, int goal) {
        if (goal < 0) return 0;
        int left = 0, right = 0, sum = 0, cnt = 0;

        while (right < nums.length) {
            sum += nums[right];

            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            cnt += right - left + 1;

            right ++;
        }
        return cnt;
    }

    static int numberOfSubarrays(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal-1);
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int k = 2;
        System.out.println(numberOfSubarrays(nums, k));
    }
}
