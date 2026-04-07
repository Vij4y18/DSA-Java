package AdvanceMath;

import java.util.Arrays;

public class CountPrime {
    static int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p * p < n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i < n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(10));
    }
}
