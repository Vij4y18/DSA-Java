package Hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

class Pair {
    int sum;
    int i;
    int j;

    Pair(int sum, int i, int j) {
        this.sum = sum;
        this.i = i;
        this.j = j;
    }
}

public class MaximumSumCombination {

    static int[] maxSumCombinations(int[] nums1, int[] nums2, int k) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n = nums1.length;
        int m = nums2.length;

        HashSet<String> visited = new HashSet<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> Integer.compare(b.sum, a.sum));

        heap.offer(new Pair(nums1[n-1]+nums2[m-1],n-1,m-1));
        visited.add((n - 1) + "," + (m - 1));

        int[] res = new int[k];
        int indx = 0;

        while (k > indx) {
            Pair curr = heap.poll();
            res[indx++] = curr.sum;

            if (curr.i > 0) {

                String key = (curr.i - 1) + "," + curr.j;

                if (!visited.contains(key)) {
                    heap.offer(new Pair(
                            nums1[curr.i - 1] + nums2[curr.j],
                            curr.i - 1,
                            curr.j
                    ));
                    visited.add(key);
                }
            }

            // Left neighbour (i, j-1)
            if (curr.j > 0) {

                String key = curr.i + "," + (curr.j - 1);

                if (!visited.contains(key)) {
                    heap.offer(new Pair(
                            nums1[curr.i] + nums2[curr.j - 1],
                            curr.i,
                            curr.j - 1
                    ));
                    visited.add(key);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {7,3};
        int[] nums2 = {1,6};
        int k = 2;


        System.out.println(Arrays.toString(maxSumCombinations(nums1,nums2,k)));
    }
}
