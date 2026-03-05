package BsOnAnswers;

public class KokoEatingBananas {
    public static int maxElement(int[] nums) {
        int maxi = -1;
        for(int i=0;i<nums.length;i++) {
            maxi = Math.max(maxi,nums[i]);
        }
        return maxi;
    }
    public static int totalHours(int[] nums, int n) {
        int totalhour = 0;
        for(int i=0; i<nums.length; i++) {
            totalhour += Math.ceil((double)nums[i]/n);
        }
        return totalhour;
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = maxElement(piles);

        while(low<=high) {
            int mid = (low+high)/2;

            if(totalHours(piles,mid) <= h) {
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] nums = {3,6,7,11};
        int h = 8;

        System.out.println(minEatingSpeed(nums, h));
    }
}
