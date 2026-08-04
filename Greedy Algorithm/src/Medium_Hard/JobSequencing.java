package Medium_Hard;

import java.util.Arrays;

public class JobSequencing {
    // Runs in O(n lg n) + O(n) + O(n*maxDeadline) and space : O(maxDeadline)
    static int[] JobScheduling(int[][] Jobs) {
        Arrays.sort(Jobs, (a,b) -> Integer.compare(b[2],a[2]));

        int maxDeadline = 0;
        for (int[] job : Jobs) {
            maxDeadline = Math.max(maxDeadline, job[1]);
        }

        int profit = 0;
        int cnt = 0;
        int[] slot = new int[maxDeadline+1];
        Arrays.fill(slot,-1);

        for (int[] job : Jobs) {
            for (int j=job[1]; j>0; j--) {
                if (slot[j] == -1) {
                    slot[j] = job[0];
                    profit += job[2];
                    cnt++;
                    break;
                }
            }
        }
        return new int[] {cnt,profit};
    }

    public static void main(String[] args) {
        int[][] Jobs = {
                {1, 2, 100},
                {2, 1, 19},
                {3, 2, 27},
                {4, 1, 25},
                {5, 1, 15}
        };
        System.out.println(Arrays.toString(JobScheduling(Jobs)));
    }
}
