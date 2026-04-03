package Bits_Easy;

public class SetOrNot_ithBit {
    static boolean setOrNot(int n, int i) {
        return ((n>>i) & 1) == 1;
    }
    public static void main(String[] args) {
        int n = 5;
        int i = 0;
        System.out.println(setOrNot(n,i));
    }
}
