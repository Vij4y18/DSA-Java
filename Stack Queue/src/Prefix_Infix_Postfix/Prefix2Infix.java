package Prefix_Infix_Postfix;

import java.util.Stack;

public class Prefix2Infix {

    static String prefix2Infix (String s) {
        Stack<String> st = new Stack<>();
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        s = str.toString();
        for (char i :  s.toCharArray()) {
            if ((i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z') || (i >= '0' && i <= '9')) {
                st.push(String.valueOf(i));
            } else {
                String t1 = st.pop();
                String t2 = st.pop();
                String connect = '(' + t1 + String.valueOf(i) + t2 + ')';
                st.push(connect);
            }
        }
        return st.peek();
    }

    public static void main(String[] args) {
        String s = "*+PQ-MN";
        System.out.println(prefix2Infix(s));
    }
}
