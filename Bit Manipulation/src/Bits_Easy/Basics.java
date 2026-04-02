package Bits_Easy;

public class Basics {
    static String decimal2Binary(int num) {
        StringBuilder ans = new StringBuilder();
        while (num!=0) {
            if (num % 2 == 1) {
                ans.append("1");
            } else {
                ans.append("0");
            }
            num = num/2;
        }
        ans.reverse();
        return ans.toString();
    }

    static int binary2Decimal (String n) {
        int ans = 0;
        int len = n.length();
        int pow2 = 1;

        for (int i=len-1;i>=0;i--) {
            if (n.charAt(i) == '1') {
                ans += pow2;
            }
            pow2 = pow2*2;
        }
        return ans;
    }
    public static void main(String[] args) {
        int num = 10;
        String n = "1101";
        System.out.println(decimal2Binary(num));
        System.out.println(binary2Decimal(n));
    }
}
