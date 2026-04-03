package Bits_Easy;

public class UnsetithBit {
    public static void main(String[] args) {
        int n = 13;
        int i = 2;

        System.out.println(n & ~(1<<i)); // unset
        System.out.println(n ^ (1<<i)); // Toggle
        System.out.println(n & (n-1)); // remove last set bit
    }
}
