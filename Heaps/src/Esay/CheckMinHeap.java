package Esay;

// CHECK IF AN ARRAY REPRESENTS A MIN HEAP

public class CheckMinHeap {

    static boolean checkMinHeap (int[] arr) {
        HeapMin heap = new HeapMin();

        for (int i=1; i<arr.length; i++) {
            if (arr[i] < arr[heap.parent(i)]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {7, 9, 8, 10, 11, 12, 14, 13};
        System.out.println(checkMinHeap(arr));
    }
}
