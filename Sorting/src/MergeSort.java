import java.util.Arrays;

public class MergeSort {

    private static void merge (int[] nums, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i = 0;
        int left = low;
        int right = mid+1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[i++] = nums[left];
                left++;
            } else {
                temp[i++] = nums[right];
                right++;
            }
        }

        while (left <= mid) {
            temp[i++] = nums[left];
            left++;
        }

        while (right <= high) {
            temp[i++] = nums[right];
            right++;
        }

        for (int j=low; j<=high; j++) {
            nums[j] = temp[j-low];
        }
    }

    private static int[] mergeSort (int[] nums, int low, int high) {
        if (low >= high) return nums;

        int mid = (low+high)/2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);
        merge(nums, low, mid, high);
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {7,5,1,3,8};
        System.out.println(Arrays.toString(mergeSort(arr,0,arr.length-1)));
    }
}
