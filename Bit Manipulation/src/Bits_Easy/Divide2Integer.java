package Bits_Easy;

public class Divide2Integer {
    static int divide(int dividend, int divisor) {
        // Edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int quotient = 0;

        while (dvd >= dvs) {
            int shift = 0;

            while (dvd >= (dvs << (shift + 1))) {
                shift++;
            }

            dvd -= (dvs << shift);
            quotient += (1 << shift);
        }

        if ((dividend < 0) ^ (divisor < 0)) {
            quotient = -quotient;
        }

        return quotient;
    }
    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        System.out.println(divide(dividend,divisor));
    }
}
