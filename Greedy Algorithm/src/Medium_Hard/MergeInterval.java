package Medium_Hard;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeInterval {
    static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));

        ArrayList<int[]> answer = new ArrayList<>();
        int[] pair = intervals[0];

        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] <= pair[1]) {
                pair[1] = Math.max(pair[1],intervals[i][1]);
            } else {
                answer.add(pair);
                pair = intervals[i];
            }
        }

        answer.add(pair);

        return answer.toArray(new int[answer.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
