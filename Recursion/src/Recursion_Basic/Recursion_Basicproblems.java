package Recursion_Basic;

public class Recursion_Basicproblems {
    // Printing N times
    static void printNtime (int n, String name) {
        if (n == 0)  return;
        printNtime(n-1, name);
        System.out.print(name + " ");
    }

    // Printing 1-N Using Recursion
    static void recursion_1_n (int n) {
        if (n == 0)  return;
        recursion_1_n(n-1);
        System.out.print(n + " ");
    }

    // Printing N-1 Using Recursion
    static void recursion_n_1 (int n) {
        if (n == 0)  return;
        System.out.print(n + " ");
        recursion_n_1(n-1);
    }

    // Printing Sum of N Natural numbers
    static int sumNnumbers (int n) {
        if (n == 1) return 1;
        return n + sumNnumbers(n-1);
    }

    // Factorial of N
    static int factorialN (int n) {
        if (n == 1) return 1;
        return n * factorialN(n-1);
    }

    public static void main(String[] args) {
        System.out.println(factorialN(5));
    }
}
