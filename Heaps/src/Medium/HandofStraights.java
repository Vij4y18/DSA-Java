package Medium;

import java.util.Arrays;

public class HandofStraights {

    static boolean isNStraightHand (int[] hands, int groupSize) {
        if (hands.length % groupSize != 0) return false;

        Arrays.sort(hands);
        int cnt = 1;
        for (int i=0; i<hands.length-1; i++) {
            if (cnt % groupSize != 0) {

            }
        }
    }

    public static void main(String[] args) {
        int[] hands = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
    }
}
