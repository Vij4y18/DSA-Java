package Easy;

public class CheckArraySorted {
    static boolean sortedArray (int[] nums) {

        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] > nums[i+1]) return false;
        }
        return true;
    }

    // Solution if Array is Rotated as well
    static boolean sortedRotatedArray (int[] nums) {
        int cnt = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > nums[(i+1)%nums.length]) cnt++;
        }

        return cnt <= 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] rotatedNums = {3,4,5,1,2};
        System.out.println(sortedArray(nums));
        System.out.println(sortedRotatedArray(rotatedNums));

    }
}
