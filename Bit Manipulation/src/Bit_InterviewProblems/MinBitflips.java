package Bit_InterviewProblems;
// Minimum Bit flips to convert number

public class MinBitflips {
    public static void main(String[] args) {
        int start = 10;
        int goal = 7;
        
        // solution
        
        int res = start ^ goal;
        int cnt = 0;
        while(res != 0) {
            res &= res - 1;
            cnt++;
        }
        System.out.println(cnt);
    }
}
