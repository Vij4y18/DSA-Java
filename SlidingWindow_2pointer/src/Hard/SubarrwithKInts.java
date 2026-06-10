package Hard;

import java.util.HashMap;
import java.util.HashSet;

public class SubarrwithKInts {

    static int atMost (int[] nums, int k) {
        int maxLen = 0;

        for (int i=0; i<nums.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j=i; j<nums.length; j++) {
                set.add(nums[j]);
                if (set.size() <= k) {
                    maxLen += 1;
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    static int atMostSlidingWindow (int[] nums, int k) {
        int left = 0;
        int cnt = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int right=0; right<nums.length; right++) {
            mpp.put(nums[right], mpp.getOrDefault(nums[right],0)+1);

            while (mpp.size() > k) {
                mpp.put(nums[left],mpp.get(nums[left])-1);

                if (mpp.get(nums[left]) == 0) {
                    mpp.remove(nums[left]);
                }
                left++;
            }

            cnt += right - left + 1;
        }
        return cnt;
    }

    static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostSlidingWindow(nums,k) - atMostSlidingWindow(nums, k-1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }
}
