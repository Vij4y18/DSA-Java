package Easy;

public class ValidParenthesis {

    static boolean checkValidString(String s) {
        int min = 0;
        int max = 0;

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                min += 1;
                max += 1;
            } else if (s.charAt(i) == ')') {
                min -= 1;
                max -= 1;
            } else {
                min -= 1;
                max += 1;
            }

            if (min < 0) min = 0;
            if (max < 0) return false;
        }
        return (min == 0);
    }

    public static void main(String[] args) {
        String s = "(*))";

        System.out.println(checkValidString(s));
    }
}
