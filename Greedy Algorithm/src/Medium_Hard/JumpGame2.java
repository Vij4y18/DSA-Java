package Medium_Hard;

public class JumpGame2 {

    static int canJump(int[] nums) {
        int l = 0;
        int r = 0;
        int jump = 0;

        while (r < nums.length - 1) {
            int farthest = 0;

            for (int ind=l; ind<=r; ind++) {
                farthest = Math.max(farthest, ind + nums[ind]);
            }

            l = r+1;
            r = farthest;
            jump += 1;
        }
        return jump;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        System.out.println(canJump(nums));
    }
}
