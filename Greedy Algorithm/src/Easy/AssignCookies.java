package Easy;

import java.util.Arrays;

public class AssignCookies {

    static int findContentChildren(int[] g, int[] s) {
        int res = 0;
        int i = 0;
        int j = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                res+=1;
                i++;
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] greed = {1,2,3};
        int[] cookie = {1,1};

        System.out.println(findContentChildren(greed,cookie));
    }
}
