package Bit_InterviewProblems;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    static List<List<Integer>> subsets(int[] nums) {
        int subsets = 1 << nums.length;
        ArrayList<List<Integer>> res = new ArrayList<>();

        for (int num=0;num<subsets;num++) {
            ArrayList<Integer> op = new ArrayList<>();
            for (int i=0;i<nums.length;i++) {
                if ((num & (1<<i)) != 0) {
                    op.add(nums[i]);
                }
            }
            res.add(op);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}
