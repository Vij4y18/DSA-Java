package BsOnAnswers;

// 1482. Minimum Number of Days to Make m Bouquets

public class Mindaysto_m_bouquets {
    public static int minimum(int[] nums) {
        int x = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
            x = Math.min(x,nums[i]);
        }
        return x;
    }
    public static int maximum(int[] nums) {
        int x = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            x = Math.max(x,nums[i]);
        }
        return x;
    }
    public static boolean canBloom(int[] nums,int d, int m, int k) {
        int cnt = 0;
        int totaldays = 0;

        for(int i=0;i<nums.length;i++) {
            if(nums[i] <= d) {
                cnt++;
            } else {
                totaldays += cnt/k;
                cnt = 0;
            }
        }
        totaldays += cnt/k;

        if(totaldays >= m) {
            return true;
        } else {
            return false;
        }
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        if ((long)m * k > bloomDay.length) return -1;

        int low = minimum(bloomDay);
        int high = maximum(bloomDay);

        while(low<=high) {
            int mid = (low+high)/2;

            if(canBloom(bloomDay,mid,m,k)) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    static void main() {
        int[] nums = {1,10,3,10,2};
        int m = 3;
        int k = 1;

        System.out.println(minDays(nums,m,k));
    }
}
