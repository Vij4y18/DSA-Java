package Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstrAtmostK {

    static int longestBrute (String s, int k) {
        int cnt = 0;

        for (int i=0; i<s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j=i; j<s.length(); j++) {
                set.add(s.charAt(j));

                if (set.size() <= k) {
                    cnt = Math.max(cnt, j-i+1);
                } else {
                    break;
                }
            }
        }
        return cnt;
    }

    static int longestOptimal (String s, int k) {
        int left = 0;
        int cnt = 0;
        HashMap<Character, Integer> mpp = new HashMap<>();

        for (int right=0; right<s.length(); right++) {
            mpp.put(s.charAt(right), mpp.getOrDefault(s.charAt(right),0)+1);

            while (mpp.size() > k) {
                mpp.put(s.charAt(left),mpp.get(s.charAt(left))-1);
                if (mpp.get(s.charAt(left)) == 0) {
                    mpp.remove(s.charAt(left));
                }
                left++;
            }

            cnt = Math.max(cnt, right-left+1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s = "aaabbccd";
        int k = 2;
        System.out.println(longestOptimal(s, k));
    }
}
