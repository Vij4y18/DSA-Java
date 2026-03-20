package Recursion_Easy;

public class Recursion_Atoi {
    static int helper(String s, int ans, int i, int sign) {
        if (i == s.length() || !Character.isDigit(s.charAt(i))) return sign * ans;

        int digit = s.charAt(i) - '0';

        // overflow check
        if (ans > (Integer.MAX_VALUE - digit) / 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        ans = ans * 10 + digit;
        return helper(s,ans,i+1,sign);
    }
    static int myAtoi(String s) {
        int sign = 1;
        int i = 0;
        int ans = 0;

        while((i < s.length()) && (s.charAt(i) == ' ')) {
            i++;
        }
        if (i == s.length()) return ans;
        if(s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if(s.charAt(i) == '+') {
            i++;
        }
        return helper(s, ans, i, sign);
    }
    public static void main(String[] args) {
        String s = "   -7126764714613946342";
        System.out.println(myAtoi(s));
    }
}
