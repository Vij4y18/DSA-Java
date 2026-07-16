package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HandofStraights {

    static boolean isNStraightHand (int[] hands, int groupSize) {
        if (hands.length % groupSize != 0) return false;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for (int num : hands) {
            mpp.put(num, mpp.getOrDefault(num,0)+1);
        }
        for (int num : mpp.keySet()) {
            heap.offer(num);
        }

        while (!heap.isEmpty()) {
            int start = heap.peek();

            for (int i=0; i<groupSize; i++) {
                int card = start+i;

                if (!mpp.containsKey(card)) {
                    return false;
                }

                mpp.put(card,mpp.get(card)-1);
            }

            while (!heap.isEmpty() && mpp.get(heap.peek()) == 0) {
                heap.poll();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hands = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;

        System.out.println(isNStraightHand(hands, groupSize));
    }
}
