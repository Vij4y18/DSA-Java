package Monotonic_Stack_Queue;

public class Sum_SubarrRanges {

    static long subArrayRanges(int[] nums) {
        long total = 0;
        for (int i=0; i<nums.length; i++) {
            int largest = Integer.MIN_VALUE;
            int smallest = Integer.MAX_VALUE;
            for(int j=i; j<nums.length; j++) {
                largest = Math.max(largest,nums[j]);
                smallest = Math.min(smallest,nums[j]);

                total += largest - smallest;
            }
        }
        return total;
    }

    static long subArrayRangesOptimal(int[] nums) {
        int maxSum = Sum_SubarrMaxs.sumSubarrayMaxs(nums); // Used Sum of Subarray Maximums
        int minSum = Sum_SubarrMins.sumSubarrayMins(nums); // Used sum of subarray Minimums

        return (long) maxSum - minSum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        System.out.println(subArrayRangesOptimal(nums));
    }
}
