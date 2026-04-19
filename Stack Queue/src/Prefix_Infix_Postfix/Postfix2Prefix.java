package Prefix_Infix_Postfix;

import java.util.Stack;

public class Postfix2Prefix {

    static String postifx2Prefix (String s) {
        Stack<String> st = new Stack<>();

        for (Character i : s.toCharArray()) {
            if ((i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z') || (i >= '0' && i <= '9')) {
                st.push(String.valueOf(i));
            } else {
                String t1 = st.pop();
                String t2 = st.pop();
                String connect = String.valueOf(i) + t2 + t1;
                st.push(connect);
            }
        }
        return st.peek();
    }

    public static void main(String[] args) {
        String s = "AB-DE+F*/";
        System.out.println(postifx2Prefix(s));
    }
}
