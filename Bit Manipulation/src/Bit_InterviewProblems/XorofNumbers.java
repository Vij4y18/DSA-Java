package Bit_InterviewProblems;

public class XorofNumbers {
    static int findXor1_n(int n) {
        if (n % 4 == 1) return 1;
        else if (n % 4 == 2) return n+1;
        else if (n % 4 == 3) return 0;
        else return n;
    }

    static int findXorL_R(int l, int r) {
        return findXor1_n(l-1) ^ findXor1_n(r);
    }

    public static void main(String[] args) {
        int n = 6;
        int l = 4;
        int r = 7;
        System.out.println(findXor1_n(n));
        System.out.println(findXorL_R(l,r));
    }
}
