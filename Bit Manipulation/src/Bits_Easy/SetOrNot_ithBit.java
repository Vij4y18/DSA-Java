package Bits_Easy;

public class SetOrNot_ithBit {
    static boolean setOrNot(int n, int i) {
        return ((n>>i) & 1) == 1;
    }
    public static void main(String[] args) {
        int n = 13;
        int i = 3;
        System.out.println(setOrNot(n,i));
    }
}
