package Easy;

/*
Notes...

1. Brute - Sort the Array and return n-2/ arr[1] for second SMALLEST
2. Better - Find Largest on first traversal and find sec largest on second traversal
 */

public class SecLargestElement {
    static int secondLargest (int[] nums) {
        int large = 0; // Assuming Array only has positives
        int secLarge = 0;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] > large) {
                secLarge = large;
                large = nums[i];
            } else if (nums[i] < large && nums[i] > secLarge) {
                secLarge = nums[i];
            }
        }

        return secLarge;
    }

    static int secondSmallest (int[] nums) {
        int small = Integer.MAX_VALUE; // Assuming Array only has positives
        int secSmall = Integer.MAX_VALUE;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] < small) {
                secSmall = small;
                small = nums[i];
            } else if (nums[i] > small && nums[i] < secSmall) {
                secSmall = nums[i];
            }
        }

        return secSmall;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,7,5,18,4};
        System.out.println(secondLargest(nums));
        System.out.println(secondSmallest(nums));
    }
}
