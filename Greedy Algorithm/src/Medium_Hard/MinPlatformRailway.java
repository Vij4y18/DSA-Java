package Medium_Hard;

import java.util.Arrays;
import java.util.PriorityQueue;

class Train {
    int arrival;
    int departure;

    Train (int arrival, int departure) {
        this.arrival = arrival;
        this.departure = departure;
    }
}

public class MinPlatformRailway {

    static int findPlatform(int[] Arrival, int[] Departure) {
        Train[] trains = new Train[Arrival.length];

        for (int i=0; i<trains.length; i++) {
            trains[i] = new Train(Arrival[i],Departure[i]);
        }

        Arrays.sort(trains, (a,b) -> Integer.compare(a.arrival, b.arrival));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(trains[0].departure);

        for (int i=1; i<trains.length; i++) {
            Train curr = trains[i];

            if (curr.arrival > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(curr.departure);
            } else {
                minHeap.offer(curr.departure);
            }
        }

        return minHeap.size();
    }

    public static void main(String[] args) {
        int[] Arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] Departure = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(findPlatform(Arrival, Departure));
    }
}
