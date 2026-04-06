package Bit_InterviewProblems;

import java.util.Arrays;

public class SingleNumberII {
    // Optimal
    static int findElement(int[] arr) {
        Arrays.sort(arr);
        for (int i=1;i<arr.length;i=i+3) {
            if (arr[i] != arr[i-1]) {
                return arr[i-1];
            }
        }
        return arr[arr.length-1];
    }

    //Bucket Method you cannot build logic just memrize this algo
    static int bucketMethod(int[] arr) {
        int ones = 0;
        int twos = 0;

        for (int i=0;i<arr.length;i++) {
            ones = (ones ^ arr[i]) & ~twos;
            twos = (twos ^ arr[i]) & ~ones;
        }

        return ones;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,1,2,4,1,4};
        System.out.println(bucketMethod(arr));
    }
}
