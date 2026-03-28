package Recursion_Hard;

import java.util.ArrayList;
import java.util.List;

public class PalindromepartitioningI {
    static boolean isPalindrome (String s, int start,int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    static void palindromepartitioning(String s, int index, List<String> list, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i=index;i<s.length();i++) {
            if (isPalindrome(s,index,i)) {
                list.add(s.substring(index,i+1));
                palindromepartitioning(s,i+1,list,res);
                list.remove(list.size()-1);
            }
        }
    }
    static List<List<String>> partitioning (String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        palindromepartitioning(s,0,list,res);
        return res;
    }
    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(partitioning(s));
    }
}
