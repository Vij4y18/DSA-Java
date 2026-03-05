package BsOnAnswers;

public class Kth_Missing_Integer {
    public static int findKthPositive(int[] arr, int k) {
        if(k < arr[0]) {return k;}
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(low<=high) {
            int mid = (low+high)/2;
            int missing = arr[mid] - (mid+1);

            if(missing < k) {
                low = mid+1;
            } else {
                high = mid - 1;
            }
        }
        return k+high+1;
    }
    static void main() {
        int[] nums = {2,3,4,7,11};
        int k = 5;

        System.out.println(findKthPositive(nums,k));
    }
}
