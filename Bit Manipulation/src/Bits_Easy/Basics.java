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
    public static void main(String[] args) {
        int num = 10;
        System.out.println(decimal2Binary(num));
    }
}
