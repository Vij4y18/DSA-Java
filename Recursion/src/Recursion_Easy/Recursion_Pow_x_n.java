package Recursion_Easy;

public class Recursion_Pow_x_n {
    // Helper Function for recursion
    static double helper (double x, int n, long nn, double ans) {
        if (nn == 0) {
            if (n<0) ans = (double)(1.0) / (double)(ans);
            return ans;
        }
        if (nn % 2 == 1) {
            ans = ans * x;
            nn = nn - 1;
        } else {
            x = x*x;
            nn = nn/2;
        }
        return helper(x,n,nn,ans);
    }
    // Recursive implementation
    static double recursivePowXn(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if (n<0) nn = -1 * n;
        return helper(x,n,nn,ans);
    }

    // Iterative implementation
    static double iterativePowXn(double x,int n) {
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
        double x = 2;
        int n = 10;
        System.out.println(recursivePowXn(x,n));
    }
}
