package BsOnAnswers;

import java.util.Arrays;

public class Aggressive_cows {
    static boolean canPlace(int[] arr, int dist, int cows) {
        int cowscnt = 1;
        int last = arr[0];

        for(int i = 1;i<arr.length;i++) {
            if(arr[i] - last >= dist) {
                cowscnt +=1;
                last = arr[i];
            }
            if(cowscnt == cows) {
                return true;
            }
        }
        return false;
    }
    static int aggressive(int[] arr, int cows) {
        Arrays.sort(arr);
        int low = 1;
        int high = (arr[arr.length-1])-arr[0];

        while(low<=high) {
            int mid = (low+high)/2;

            if(canPlace(arr,mid,cows)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    static void main() {
        int []arr = {0,3,4,7,10,9};
        int cows = 4;

        System.out.println(aggressive(arr,cows));
    }
}
