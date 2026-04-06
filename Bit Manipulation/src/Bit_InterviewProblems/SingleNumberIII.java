package Bit_InterviewProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumberIII {
    static int[] better(int[] arr) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for (int i=0;i<arr.length;i++) {
            mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);
        }

        int[] res = new int[2];
        int indx = 0;
        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            if (entry.getValue() == 1) {
                res[indx++] = entry.getKey();
            }
        }
        return res;
    }

    static int[] optimal(int[] arr) {
        int xor = 0;

        for (int num : arr) {
            xor ^= num;
        }

        // Get rightmost set bit
        int rightmostSetBit = xor & -xor;

        int x = 0, y = 0;

        for (int num : arr) {
            if ((num & rightmostSetBit) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        return new int[]{x, y};
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,2,5};

        System.out.println(Arrays.toString(optimal(arr)));
    }
}
