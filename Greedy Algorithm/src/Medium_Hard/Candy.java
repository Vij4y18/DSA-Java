package Medium_Hard;

public class Candy {
    // Brute take O(3n) time and O(2n) space
    static int bruteCandy (int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        left[0] = 1;

        for (int i=1; i<ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                left[i] = left[i-1]+1;
            } else {
                left[i] = 1;
            }
        }

        right[ratings.length-1] = 1;

        for (int i=ratings.length-2; i>=0; i--) {
            if (ratings[i] > ratings[i+1]) {
                right[i] = right[i+1]+1;
            } else {
                right[i] = 1;
            }
        }

        int candies = 0;

        for (int i=0; i<ratings.length; i++) {
            candies += Math.max(left[i],right[i]);
        }

        return candies;
    }

    // Better takes O(3n) time and O(n) space
    static int betterCandy (int[] ratings) {
        int[] candy = new int[ratings.length];

        candy[0] = 1;

        for (int i=1; i<ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candy[i] = candy[i-1]+1;
            } else {
                candy[i] = 1;
            }
        }

        for (int i=ratings.length-2; i>=0; i--) {
            if (ratings[i] > ratings[i+1]) {
                if (candy[i] <= candy[i+1]) {
                    candy[i] = candy[i+1]+1;
                }
            }
        }

        int candies = 0;

        for (int i=0; i<ratings.length; i++) {
            candies += candy[i];
        }

        return candies;
    }

    static int optimalCandy(int[] ratings) { // runs in O(1) Space
        int n = ratings.length;

        // Initially give 1 candy to each child
        int candies = n;

        // Start from second child
        int i = 1;

        while (i < n) {

            // Skip equal ratings
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }

            // Initialize increasing slope counter
            int peak = 0;

            // Traverse strictly increasing ratings
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                candies += peak;
                i++;
            }

            // Initialize decreasing slope counter
            int valley = 0;

            // Traverse strictly decreasing ratings
            while (i < n && ratings[i] < ratings[i - 1]) {
                valley++;
                candies += valley;
                i++;
            }

            // Remove overlapping candy at the peak
            candies -= Math.min(peak, valley);
        }

        // Return total candies required
        return candies;
    }

    public static void main(String[] args) {
        int[] ratings = {1,2,2};

        System.out.println(bruteCandy(ratings));
    }
}
