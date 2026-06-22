package Hard;

public class MinWindowSubStr {

    static String minWindowBrute (String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int sIndex = 0;

        for (int i=0; i<s.length(); i++) {
            int[] hash = new int[256];
            int cnt = 0;

            for (int j=0; j<t.length(); j++) {
                hash[t.charAt(j)]++;
            }

            for (int j=i; j<s.length(); j++) {
                if (hash[s.charAt(j)] > 0) {
                    cnt++;
                }
                hash[s.charAt(j)]--;

                if (cnt == t.length()) {
                    if (minLen > j-i+1) {
                        minLen = j-i+1;
                        sIndex = i;
                    }
                    break;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(sIndex,sIndex+minLen);
    }

    static String minWindowOptimal (String s, String t) {
        int[] hash = new int[256];
        int minLen = Integer.MAX_VALUE;
        int sIndex = 0;
        int cnt = 0;
        int left = 0;

        for (int i=0; i<t.length(); i++) {
            hash[t.charAt(i)]++;
        }

        for (int right=0; right<s.length(); right++) {
            if (hash[s.charAt(right)] > 0) {
                cnt++;
            }
            hash[s.charAt(right)]--;

            while (cnt == t.length()) {
                if (right-left+1 < minLen) {
                    minLen = right-left+1;
                    sIndex = left;
                }
                hash[s.charAt(left)]++;
                if (hash[s.charAt(left)] > 0) {
                    cnt--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(sIndex,sIndex+minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindowBrute(s,t));
        System.out.println(minWindowOptimal(s, t));
    }
}
