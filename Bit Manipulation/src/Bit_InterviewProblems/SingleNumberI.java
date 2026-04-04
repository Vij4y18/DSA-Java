package Bit_InterviewProblems;

public class SingleNumberI {
    public static void main(String[] args) {
        int[] arr = {1,4,2,2,1};

        // Solve
        int xor = 0;
        for (int i=0;i<arr.length;i++) {
            xor = xor ^ arr[i];
        }
        System.out.println(xor);
    }
}
