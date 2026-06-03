package Medium;

import java.util.HashMap;
import java.util.HashSet;

public class FruitIntoBaskets {

    static int bruteApproach (int[] fruits) {
        int maxLen = 0;

        for (int i=0; i<fruits.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j=i; j<fruits.length; j++) {
                set.add(fruits[j]);
                if (set.size() <= 2) {
                    maxLen = Math.max(maxLen, j-i+1);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    // Better solution runs in O(2N)
    static int fruitInBaskets (int[] fruits) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for (int right=0; right<fruits.length; right++) {
            mpp.put(fruits[right],mpp.getOrDefault(fruits[right],0)+1);

            while (mpp.size() > 2) {
                mpp.put(fruits[left],mpp.get(fruits[left])-1);
                if (mpp.get(fruits[left]) == 0) {
                    mpp.remove(fruits[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }


    // Runs in O(N) so slightly better than previous one
    static int fruitInBasketsOptimal (int[] fruits) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for (int right=0; right<fruits.length; right++) {
            mpp.put(fruits[right],mpp.getOrDefault(fruits[right],0)+1);

            if (mpp.size() > 2) {
                mpp.put(fruits[left],mpp.get(fruits[left])-1);
                if (mpp.get(fruits[left]) == 0) {
                    mpp.remove(fruits[left]);
                }
                left++;
            }
            if (mpp.size() <= 2) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(bruteApproach(fruits));
        System.out.println(fruitInBaskets(fruits));
    }
}
