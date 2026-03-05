package Bs_2D_array;

public class Matrix_median {
    public static int lowerbound(int[] nums, int x) {
        int low = 0;
        int high = nums.length-1;
        int ans = nums.length;

        while(low<=high) {
            int mid = (low+high)/2;

            if(nums[mid] > x) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static int smallequal(int[][] matrix, int x) {
        int cnt = 0;

        for(int i=0;i< matrix.length;i++) {
            cnt += lowerbound(matrix[i],x);
        }
        return cnt;
    }
    public static int median(int[][] matrix, int n, int m) {
        int req = (n*m)/2;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++) {
            low = Math.min(low,matrix[i][0]);
            high = Math.max(high,matrix[i][m-1]);
        }

        while(low<=high) {
            int mid = (low+high)/2;

            int smallequals = smallequal(matrix,mid);

            if(smallequals <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };
        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println(median(matrix,n,m));
    }
}
