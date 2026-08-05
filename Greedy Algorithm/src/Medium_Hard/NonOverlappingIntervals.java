package Medium_Hard;

import java.util.Arrays;

public class NonOverlappingIntervals {

    static int eraseOverlapIntervals(int[][] intervals) { // Runs in O(n log n) + O(n) time and O(1) space
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1],b[1]));

        int end = intervals[0][1];
        int cnt = 0;

        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
            } else {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };

        System.out.println(eraseOverlapIntervals(intervals));
    }
}
