package AdvanceMath;

public class PowX_N {
    static double powXn(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if (n<0) nn = -1 * nn;

        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;
            } else {
                x = x*x;
                nn = nn/2;
            }
        }
        if (n<0) ans = (double)(1.0) / (double)(ans);
        return ans;
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 10;
        System.out.println(powXn(x,n));
    }
}
