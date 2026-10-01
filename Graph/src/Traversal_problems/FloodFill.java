package Traversal_problems;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        for (int[] row : image) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println(); // new line

        int[][] newImage = floodFill(image,1 ,1, 2); // calling our function

        for (int[] row : newImage) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor = image[sr][sc];

        if (initialColor == color) {
            return image;
        }

        dfsHelper(sr, sc, initialColor, image, color);

        return image;
    }

    static void dfsHelper (int row, int col, int iniClr, int[][] image, int color) {
        image[row][col] = color;

        // creating range, you can also create an direction array as well
        int rowStart = row > 0 ? row-1 : row;
        int rowEnd = row < image.length-1 ? row+1 : row;
        int colStart = col > 0 ? col-1 : col;
        int colEnd = col < image[0].length-1 ? col+1 : col;

        for (int i=rowStart; i<=rowEnd; i++) {
            for (int j=colStart; j<=colEnd; j++) {
                // skip diagonals
                if (i != row && j != col) continue;

                if (image[i][j] == iniClr) {
                    dfsHelper (i, j, iniClr, image, color);
                }
            }
        }
    }
}
