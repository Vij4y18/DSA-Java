package Bs_2D_array;

public class Find_row_with_max1s {
    public static int find1s(int[][] matrix,int n,int m) {
        int maxi = -1;
        int row = -1;

        for(int i=0;i<n;i++) {
            int low = 0;
            int high = m-1;

            while(low<=high) {
                int mid = (low+high)/2;

                if(matrix[i][mid] >= 1) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if((m-low) > maxi) {
                maxi = m-low;
                row = i;
            }
        }
        return row;
    }
    static void main() {
        int[][] matrix = {{0,1,1},{0,0,0},{1,1,1}};
        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println(find1s(matrix,m,n));
    }
}
