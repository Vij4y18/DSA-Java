package Easy;

import java.util.ArrayList;

class MaximumHeap {
    ArrayList<Integer> heap;

    MaximumHeap() {
        heap = new ArrayList<>();
    }

    int parent(int i) {
        return (i-1)/2;
    }

    int leftChild(int i) {
        return (i*2)+1;
    }

    int rightChild(int i) {
        return (i*2)+2;
    }

    void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }

    void insert (int value) {
        heap.add(value);
        int index = heap.size()-1;

        while (index > 0 && heap.get(parent(index)) < heap.get(index)) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    void print() {
        System.out.println(heap);
    }
}

public class MaxHeap {
    public static void main(String[] args) {
        MaximumHeap maxHeap = new MaximumHeap();

        maxHeap.insert(9);
        maxHeap.insert(6);
        maxHeap.insert(5);
        maxHeap.insert(7);
        maxHeap.insert(13);
        maxHeap.insert(10);
        maxHeap.insert(11);
        maxHeap.insert(14);
        maxHeap.insert(12);
        maxHeap.insert(1);

        maxHeap.print();
    }
}
