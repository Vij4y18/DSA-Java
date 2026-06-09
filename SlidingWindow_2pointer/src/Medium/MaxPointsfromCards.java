package Medium;

// Sliding Window bur window slides in reverse

public class MaxPointsfromCards {

    static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftSum = 0;
        int rightSum = 0;

        for (int i=0; i<k; i++) {
            leftSum += cardPoints[i];
        }

        int totalSum = leftSum;
        int rightIndex = n-1;

        for (int i=k-1; i>=0; i--) {
            leftSum -= cardPoints[i];

            rightSum += cardPoints[rightIndex--];

            totalSum = Math.max(totalSum, leftSum+rightSum);
        }
        return totalSum;
    }

    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }
}
