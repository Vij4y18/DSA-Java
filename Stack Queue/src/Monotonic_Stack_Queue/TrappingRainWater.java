package Monotonic_Stack_Queue;

public class TrappingRainWater {

    static int trap(int[] height) {
        int leftmax = 0;
        int rightmax = 0;
        int total = 0;

        int l = 0;
        int r = height.length-1;

        while(l<r) {
            if (height[l]<=height[r]) {
                if (leftmax > height[l]) {
                    total += leftmax - height[l];
                } else {
                    leftmax = height[l];
                }
                l+=1;
            } else {
                if (rightmax > height[r]) {
                    total += rightmax - height[r];
                } else {
                    rightmax = height[r];
                }
                r-=1;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
