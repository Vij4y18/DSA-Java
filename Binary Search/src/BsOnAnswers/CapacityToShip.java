package BsOnAnswers;

public class CapacityToShip {
    public static int maximum(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for (int num : nums) {
            maxi = Math.max(maxi, num);
        }
        return maxi;
    }
    public static int total(int[] nums) {
        int maxi = 0;
        for(int i=0;i<nums.length;i++) {
            maxi+=nums[i];
        }
        return maxi;
    }
    public static boolean weightCapacity(int[] nums, int days, int w) {
        int cnt = 0;
        int d = 1;

        for(int i=0; i<nums.length;i++) {
            cnt += nums[i];
            if (cnt > w) {
                d += 1;
                cnt = nums[i];
            }
        }
        return d<=days;
    }
    public static int shipWithinDays(int[] weights, int days) {
        int high = total(weights);
        int low = maximum(weights);

        while(low<=high) {
            int mid = (low+high)/2;

            if(weightCapacity(weights,days,mid)) {
                high = mid -1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
    static void main() {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println(shipWithinDays(weights,days));
    }
}
