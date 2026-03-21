package Recursion_Easy;

public class Recursion_CountGoodnums {
    static final long MOD = 1000000007;

    static long power(long x, long y) {
        long result = 1;
        x = x % MOD;

        while (y > 0) {
            if ((y & 1) == 1) { // if y is odd
                result = (result * x) % MOD;
            }
            x = (x * x) % MOD;
            y = y >> 1; // divide y by 2
        }
        return result;
    }

    static int countGoodNumbers(long n) {
        long odd = n/2;
        long even = (n+1)/2;
        return (int)(power(5,even)*(power(4,odd)) % MOD);
    }


    public static void main(String[] args) {
        int n = 5;
        System.out.println(countGoodNumbers(n));
    }
}
