package Easy;

import java.util.ArrayList;

class HeapMin {
    ArrayList<Integer> heap;

    HeapMin() {
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

    void insert(int value) {
        heap.add(value);

        int index = heap.size()-1;

        while (index > 0 && heap.get(parent(index)) > heap.get(index)) {
            swap(index,parent(index));
            index = parent(index);
        }
    }
    void extractMin() {
        int root = heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int index = 0;

        while (leftChild(index) < heap.size()) {

            int smallerChild = leftChild(index);

            if (rightChild(index) < heap.size() && heap.get(rightChild(index)) < heap.get(leftChild(index))) {
                smallerChild = rightChild(index);
            }

            if (heap.get(index) <= heap.get(smallerChild)) {
                break;
            }

            swap(index, smallerChild);
            index = smallerChild;
        }
    }

    void print() {
        System.out.println(heap);
    }

}

public class MinHeap {
    public static void main(String[] args) {
        HeapMin minheap = new HeapMin();

        minheap.insert(8);
        minheap.insert(10);
        minheap.insert(7);
        minheap.insert(9);
        minheap.insert(11);
        minheap.insert(12);
        minheap.insert(14);
        minheap.insert(13);

        minheap.print();

        minheap.insert(2);
        minheap.print();

        minheap.extractMin();
        minheap.print();
    }
}
