package Medium_Hard;

import java.util.ArrayList;
import java.util.Arrays;

class Pair {
    int start;
    int end;
    int index;

    Pair(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

public class Nmeetings {

    static int maxMeetings(int[] start, int[] end) {
        Pair[] arr = new Pair[start.length];

        for (int i=0; i<start.length; i++) {
            arr[i] = new Pair(start[i],end[i],i);
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(a.end,b.end));

        ArrayList<Integer> order = new ArrayList<>();
        int count = 1;

        int lastEndTime = arr[0].end;
        order.add(arr[0].index);


        for (int i=1; i<arr.length; i++) {
            if (arr[i].start > lastEndTime) {
                count++;
                order.add(arr[i].index);
                lastEndTime = arr[i].end;
            }
        }

        System.out.println(order);
        return count;
    }

    public static void main(String[] args) {
        int[] Start = {1, 3, 0, 5, 8, 5};
        int[] End = {2, 4, 6, 7, 9, 9};

        System.out.println(maxMeetings(Start,End));
    }
}
