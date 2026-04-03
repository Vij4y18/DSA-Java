package Bits_Easy;

public class Pow2ornot {
    public static void main(String[] args) {
        int n = 64;

        if((n & (n-1)) == 0) System.out.println(true);
        else System.out.println(false);
    }
}
