package Prefix_Infix_Postfix;

import java.util.Stack;

public class Prefix2Postfix {

    static String prefix2Postfix(String s) {
        Stack<String> st = new Stack<>();

        StringBuilder str = new StringBuilder(s);
        str.reverse();
        s = str.toString();

        for (Character i : s.toCharArray()) {
            if ((i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z') || (i >= '0' && i <= '9')) {
                st.push(String.valueOf(i));
            } else {
                String t1 = st.pop();
                String t2 = st.pop();

                String connect = t1 + t2 + String.valueOf(i);
                st.push(connect);
            }
        }
        return st.peek();
    }

    public static void main(String[] args) {
        String s = "/-AB*+DEF";
        System.out.println(prefix2Postfix(s));
    }
}
