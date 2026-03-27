package Recursion_Subsequences_Pattern;
import java.util.*;
public class LetterCombination {
    static void solve(int index, String digits, StringBuilder current, List<String> ans, String[] map) {

        // ✅ Base Case
        if (index == digits.length()) {
            ans.add(current.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {
            current.append(ch); // choose
            solve(index + 1, digits, current, ans, map);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }

    static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;

        String[] map = {
                "", "", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        solve(0, digits, new StringBuilder(), ans, map);
        return ans;
    }
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
