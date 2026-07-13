package Medium;

// Replace Array element by its rank

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class ReplaceElement {

    static int[] rankElements (int[] arr) {
        int[] temp = new int[arr.length];
        Map<Integer, Integer> mpp = new HashMap<>();

        for (int i=0; i<arr.length; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp);

        int rank = 1;
        for (int i=0; i<temp.length; i++) {
            if (!mpp.containsKey(temp[i])) {
                mpp.put(temp[i],rank);
                rank++;
            }
        }

        for (int i=0; i<arr.length; i++) {
            arr[i] = mpp.get(arr[i]);
        }

        return arr;
    }

    public static void main (String[] args) {
        int[] arr = {20,15,26,2,98,6};

        System.out.println(Arrays.toString(rankElements(arr)));
    }
}
