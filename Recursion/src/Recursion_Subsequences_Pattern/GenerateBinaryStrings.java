package Recursion_Subsequences_Pattern;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStrings {
    static void generateString (int n, String s, List<String> res) {
        if (s.length() == n) {
            res.add(s);
            return;
        }
        generateString(n,s+"0",res);
        if(s.isEmpty() || s.charAt(s.length()-1) != 1) {
            generateString(n,s+"1",res);
        }
    }
    public static void main(String[] args) {
        int n = 2;
        ArrayList<String> res = new ArrayList<>();
        generateString(n,"",res);
        System.out.println(res);
    }
}
