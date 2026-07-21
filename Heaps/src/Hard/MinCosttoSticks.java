package Hard;

import java.util.PriorityQueue;

public class MinCosttoSticks {  // Time: O(n log n)

    static int connectSticks (int[] sticks) {
        if (sticks.length == 1) {
            return -1; // Only one stick
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int totalCost = 0;

        for (int stick : sticks) {
            heap.offer(stick);
        }

        while (heap.size() > 1) {
            int connectedStick = heap.poll() + heap.poll(); // Connecting Smallest sticks

            totalCost += connectedStick;

            heap.offer(connectedStick);
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int[] sticks = {2,4,3};

        System.out.println(connectSticks(sticks));
    }
}
