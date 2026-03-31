package Recursion_Hard;

// This is not optimal solution. Optimal solution will be done once i learn DP concept

import java.util.*;

public class WordBreak {
    static boolean wordCheck (String s, Set<String> dict) {
        if (s.length() == 0) return true;

        for (int i=1;i<=s.length(); i++) {
            String prefix = s.substring(0,i);

            if (dict.contains(prefix)) {
                if (wordCheck(s.substring(i,s.length()),dict)) {
                    return true;
                }
            }
        }
        return false;
    }
    static boolean wordBreak (String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        return wordCheck(s,dict);
    }
    public static void main(String[] args) {
        String s = "leetcode";
        ArrayList<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s,wordDict));
    }
}
