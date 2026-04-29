package Monotonic_Stack_Queue;

import java.util.Stack;

public class RemoveKDigits {

    static String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";

        Stack<Character> st = new Stack<>();

        for (int i=0; i<num.length(); i++) {
            while (!st.isEmpty() && k>0 && st.peek() > num.charAt(i)) {
                st.pop();
                k-=1;
            }
            st.push(num.charAt(i));
        }

        while (k>0) {
            st.pop();
            k -= 1;
        }

        StringBuilder str = new StringBuilder();

        while (!st.isEmpty()) {
            str.append(st.pop());
        }

        str.reverse();

        while(str.length() > 0 && str.charAt(0) == '0') {
            str.deleteCharAt(0);
        }

        return str.length() == 0 ? "0" : str.toString();
    }

    public static void main(String[] args) {
        String s = "1432219";
        int k = 3;

        System.out.println(removeKdigits(s,k));
    }
}
