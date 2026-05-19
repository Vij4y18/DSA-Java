package Easy;

/*
BRUTE ---
Use Extra Array
-> store all the non-zero value into temp array
-> then fill out remaining places with zeros
 */

import java.util.Arrays;

public class MoveZeros {

    static int[] moveZeros (int[] nums) {
        int indx = 0;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                indx = i;
                break;
            }
        }

        for (int i=indx+1; i<nums.length; i++) {
            if (nums[i] != 0) {
                nums[indx] = nums[i];
                nums[i] = 0;
                indx++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,0,1,0,4,0,5,0};
        System.out.println(Arrays.toString(moveZeros(arr)));
    }
}
