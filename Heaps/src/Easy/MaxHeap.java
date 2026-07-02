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

    int delete() {
        if(isEmpty()) return -1;
        int root = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int index = 0;

        while (leftChild(index) < heap.size()) {

            int largerChild = leftChild(index);

            if (rightChild(index) < heap.size() &&
                    heap.get(rightChild(index)) > heap.get(leftChild(index))) {
                largerChild = rightChild(index);
            }

            // Heap property satisfied
            if (heap.get(index) >= heap.get(largerChild)) {
                break;
            }

            swap(index, largerChild);
            index = largerChild;
        }
        return root;
    }

    void print() {
        System.out.println(heap);
    }

    boolean isEmpty() {
        return heap.isEmpty();
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
        System.out.println(maxHeap.delete());
        maxHeap.print();
    }
}
