package Medium;

class Solution {
    public int atMost (int[] nums, int goal) {
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

    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal-1);
    }
}

public class BinarySubarrWithSum {

    static int brute (int[] nums, int goal) {
        int cnt = 0;

        for (int i=0; i<nums.length; i++) {
            int sum = 0;
            for (int j=i; j<nums.length; j++) {
                sum += nums[j];

                if (sum == goal) cnt++;
                else if (sum > goal) break;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int k = 2;

        Solution ans = new Solution();

        int sol = ans.numSubarraysWithSum(nums, k);
        System.out.println(sol);
        // System.out.println(brute(nums, k));
    }
}
