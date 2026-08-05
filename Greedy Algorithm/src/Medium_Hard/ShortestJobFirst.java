package Medium_Hard;

import java.util.Arrays;

public class ShortestJobFirst {

    static long solve(int[] bt) {
        //your code goes here
        Arrays.sort(bt);

        int time = 0;
        int waitTime = 0;

        for (int i=0; i<bt.length; i++) {
            waitTime += time;
            time += bt[i];
        }

        return waitTime/bt.length;
    }

    public static void main(String[] args) {
        int[] executionTime = {1, 2, 3, 4};

        System.out.println(solve(executionTime));
    }
}
