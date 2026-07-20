package Hard;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

public class TopKFreqElements {

    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Integer.compare(mpp.get(a), mpp.get(b)));

        for (int num : nums) {
            mpp.put(num,mpp.getOrDefault(num,0)+1);
        }

        for (int i : mpp.keySet()) {
            if (heap.size() < k) {
                heap.offer(i);
            } else if (mpp.get(i) > mpp.get(heap.peek())) {
                heap.poll();
                heap.offer(i);
            }
        }

        int[] res = new int[k];
        for (int i=0; i<k; i++) {
            res[i] = heap.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
