package Bs_1D_array;

public class Binary_recursive {
    public static int recursion(int[] arr, int target, int low, int high) {
        if(low > high) {
            return -1;
        }
        int mid  = (low+high)/2;

        if(arr[mid] == target) {
            return mid;
        } else if(arr[mid] > target) {
            return recursion(arr,target,low,mid-1);
        } else {
            return recursion(arr,target,mid+1,high);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int target = 1;
        int low = 0;
        int high = arr.length - 1;

        System.out.println(recursion(arr,target,low,high));


    }
}
