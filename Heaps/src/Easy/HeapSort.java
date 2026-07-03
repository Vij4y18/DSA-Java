package Easy;

import java.util.Arrays;

public class HeapSort {

    static void heapify(int[] arr, int index, int size) {
        while (2 * index + 1 < size) {

            int largerChild = 2 * index + 1;

            if (2 * index + 2 < size &&
                    arr[2 * index + 2] > arr[2 * index + 1]) {
                largerChild = 2 * index + 2;
            }

            if (arr[index] >= arr[largerChild]) {
                break;
            }

            int temp = arr[index];
            arr[index] = arr[largerChild];
            arr[largerChild] = temp;

            index = largerChild;
        }
    }

    static void buildMaxHeap(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    static void heapSort(int[] arr) {
        int n = arr.length;

        buildMaxHeap(arr);

        for (int i = n - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};

        heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}