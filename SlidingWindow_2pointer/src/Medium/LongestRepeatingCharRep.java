package Medium;

/*
BRUTE Approach Explained

1. We need to find MaxFrequency by counting all the frequency of characters

2. Characters to replace = current length - maxFreq

3. if characters to replace <= k then substring is valid (update maxLength)
 */

public class LongestRepeatingCharRep {

    static int characterReplacementBrute(String s, int k) {
        int maxLen = 0;

        for (int i=0; i<s.length(); i++) {
            int maxFreq = 0;
            int[] freq = new int[26];
            for (int j=i; j<s.length(); j++) {
                freq[s.charAt(j) - 'A']++;
                maxFreq = Math.max(maxFreq,freq[s.charAt(j) - 'A']);

                int len = j-i+1;

                if (len - maxFreq <= k) {
                    maxLen = Math.max(maxLen, len);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    static int characterReplacementOptimal(String s, int k) {
        int left = 0;
        int maxLen = 0;
        int maxFreq = 0;
        int[] freq = new int[26];

        for (int right=0; right<s.length(); right++) {
            freq[s.charAt(right) -'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            if ((right-left+1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            if ((right-left+1) - maxFreq <= k) {
                maxLen = Math.max(maxLen, right-left+1);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "AABA";
        int k = 1;
        System.out.println(characterReplacementBrute(s,k));
    }
}
