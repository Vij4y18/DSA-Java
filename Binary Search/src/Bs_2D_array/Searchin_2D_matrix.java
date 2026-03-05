package Bs_2D_array;

public class Searchin_2D_matrix {
    public static boolean searchMatrix(int[][] matrix, int target) { // THIS RUNS IN O(n log m)
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0;i<n;i++) {
            int low = 0;
            int high = m-1;


            while(low<=high) {
                int mid = (low+high)/2;
                if(matrix[i][mid] == target) {
                    return true;
                } else if(matrix[i][mid] > target) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
        }
        return false;
    }
    public static boolean searchMatrix2(int[][] matrix, int target) { // TRUE O(log(m*n)) SOLUTION...
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = m*n-1;

        while(low<=high) {
            int mid = (low+high)/2;
            int row = mid/m;
            int col = mid%m;

            if(matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
    static void main() {
        int[][] matrix = {{11,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int target = 8;

        System.out.println(searchMatrix2(matrix,target));
    }
}
