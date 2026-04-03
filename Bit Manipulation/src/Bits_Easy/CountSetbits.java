package Bits_Easy;

public class CountSetbits {
    public static void main(String[] args) {
        int n = 13;
        int cnt = 0;
        while (n != 0) {
            n &= n-1;
            cnt++;
        }
        System.out.println(cnt);
    }
}
