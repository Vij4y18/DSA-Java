package Bs_2D_array;
import java.util.Arrays;

import org.w3c.dom.ls.LSOutput;

public class Find_peak_2D {
    public static int maxElement(int[][] mat, int col) {
        int maxi = -1;
        int row = -1;

        for(int i=0;i<mat.length;i++) {
            if(mat[i][col] > maxi) {
                maxi = mat[i][col];
                row = i;
            }
        }
        return row;
    }
    public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m-1;
        int[] peak = {-1,-1};

        while(low<=high) {
            int mid = (low+high)/2;

            int row = maxElement(mat,mid);

            int left = mid-1 >= 0 ? mat[row][mid-1] : -1;
            int right = mid+1 < m ? mat[row][mid+1] : -1;

            if(mat[row][mid] > left && mat[row][mid] > right) {
                peak[0] = row;
                peak[1] = mid;
                return peak;
            } else if(left > mat[row][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return peak;
    }
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 5, 1, 4, 5},
                {2, 9, 3, 2, 3, 2},
                {1, 7, 6, 0, 1, 3},
                {3, 6, 2, 3, 7, 2}
        };

        System.out.println(Arrays.toString(findPeakGrid(mat)));    }
}
