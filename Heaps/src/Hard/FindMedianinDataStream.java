package Hard;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        // Inserting
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Re-Balance
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (((long) maxHeap.peek() + minHeap.peek()) / 2.0);
        } else {
            return maxHeap.peek();
        }
    }
}

public class FindMedianinDataStream {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();

        obj.addNum(1);
        System.out.println("null");

        obj.addNum(2);
        System.out.println("null");

        System.out.println(obj.findMedian()); // 1.5

        obj.addNum(3);
        System.out.println("null");

        System.out.println(obj.findMedian()); // 2.0
    }
}
