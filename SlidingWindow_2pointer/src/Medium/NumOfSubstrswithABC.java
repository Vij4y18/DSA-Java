package Medium;

public class NumOfSubstrswithABC {

    static int numberOfSubstringsBrute(String s) {
        int cnt = 0;
        int n = s.length();

        for (int i=0; i<n; i++) {
            int[] hash = new int[3];
            for (int j=i; j<n; j++) {
                hash[s.charAt(j) - 'a'] = 1;
                if (hash[0] + hash[1] + hash[2] == 3) {
                    cnt += n-j;
                    break;
                }
            }
        }
        return cnt;
    }

    static int numberOfSubstringsOptimal(String s) {
        int cnt = 0;
        int[] hash = {-1,-1,-1};

        for (int i=0 ;i<s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i;

            int minVal = Math.min(hash[0],Math.min(hash[1], hash[2]));

            if (minVal != -1) {
                cnt += minVal+1;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstringsBrute(s));
        System.out.println(numberOfSubstringsOptimal(s));
    }
}
