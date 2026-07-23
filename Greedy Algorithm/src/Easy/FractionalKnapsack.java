package Easy;

import java.util.Arrays;

class Item {
    int val;
    int wt;
    double ratio;

    Item (int val,int wt) {
        this.val = val;
        this.wt = wt;
        this.ratio = (double) val/wt;
    }
}

public class FractionalKnapsack {
    // Optimal takes O(n) + O(n log n) + O(n) overall - O(n log n)
    static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        Item[] arr = new Item[val.length];

        for (int i=0; i<val.length; i++) {
            arr[i] = new Item(val[i],wt[i]);
        }

        Arrays.sort(arr, (a, b) -> Double.compare(b.ratio, a.ratio));

        int indx = 0;
        double res = 0;
        while (capacity > 0 && indx < val.length) {
            Item curr = arr[indx++];

            if (curr.wt <= capacity) { // If you can take, Take all (Greedy)
                res += curr.val;
                capacity -= curr.wt;
            } else {
                res += curr.ratio * (double) capacity;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] val = {60,100,120};
        int[] weight = {10,20,30};
        int capacity = 50;

        System.out.println(fractionalKnapsack(val,weight,capacity));
    }
}
