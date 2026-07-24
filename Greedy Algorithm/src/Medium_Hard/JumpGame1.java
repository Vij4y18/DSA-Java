package Medium_Hard;

public class JumpGame1 {

    static boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        int maxIndex = 0;
        int goal = nums.length-1;

        for (int i=0; i<nums.length-1; i++) {
            if (i > maxIndex) return false;

            maxIndex = Math.max(maxIndex, nums[i]+i);

            if (maxIndex >= goal) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        System.out.println(canJump(nums));
    }
}
