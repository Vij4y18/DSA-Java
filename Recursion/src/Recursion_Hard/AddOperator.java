package Recursion_Hard;

import java.util.ArrayList;
import java.util.List;

public class AddOperator {
    class Solution {
        static List<String> addOperators(String num, int target) {
            List<String> ans = new ArrayList<>();
            solve(0, "", 0, 0, num, target, ans);
            return ans;
        }

        static void solve(int index, String path, long value, long prev,
                   String num, int target, List<String> ans) {

            if (index == num.length()) {
                if (value == target) {
                    ans.add(path);
                }
                return;
            }

            for (int i = index; i < num.length(); i++) {

                // ❌ skip leading zeros
                if (i > index && num.charAt(index) == '0') break;

                long curr = Long.parseLong(num.substring(index, i + 1));

                if (index == 0) {
                    solve(i + 1, path + curr, curr, curr, num, target, ans);
                } else {

                    // +
                    solve(i + 1, path + "+" + curr,
                            value + curr, curr, num, target, ans);

                    // -
                    solve(i + 1, path + "-" + curr,
                            value - curr, -curr, num, target, ans);

                    // *
                    solve(i + 1, path + "*" + curr,
                            value - prev + (prev * curr),
                            prev * curr, num, target, ans);
                }
            }
        }
    }

    public static void main(String[] args) {
        String num = "123";
        int target = 6;
        System.out.println(Solution.addOperators(num,target));

    }
}
