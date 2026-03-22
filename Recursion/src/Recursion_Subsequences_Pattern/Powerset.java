package Recursion_Subsequences_Pattern;

public class Powerset {
    // Power set Bit manipulation approach
    static void powerSetLinear (String s) {
        int n = s.length();
        int total = 1 << n; // 2^n

        for (int num = 0; num < total; num++) {
            String sub = "";

            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0) {
                    sub += s.charAt(i);
                }
            }
            System.out.println(sub);
        }
    }

    // Recursive approach
    static void powerSetRecursive(String s, int index, String current) {
        if (index == s.length()) {
            System.out.println(current);
            return;
        }
        // 1. TAKE
        powerSetRecursive(s,index+1,current + s.charAt(index));

        // 2. NOT TAKE
        powerSetRecursive(s,index+1,current);
    }
    public static void main(String[] args) {
        String s = "abc";
        powerSetRecursive(s,0," ");
        powerSetLinear(s);
    }
}
