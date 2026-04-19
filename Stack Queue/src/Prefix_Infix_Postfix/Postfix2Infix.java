package Prefix_Infix_Postfix;

import java.util.Stack;

public class Postfix2Infix {
    static boolean operand (Character i) {
        if ((i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z') || (i >= '0' && i <= '9'))  return true;
        else return false;
    }

    static String postfix2Infix(String s) {
        Stack<String> st = new Stack<>();

        for (Character i : s.toCharArray()) {
            if (operand(i)) {
                st.push(String.valueOf(i));
            } else {
                String t1 = st.pop();
                String t2 = st.pop();
                String connected = '(' + t2 + String.valueOf(i) + t1 + ')';
                st.push(connected);
            }
        }
        return st.peek();
    }
    public static void main(String[] args) {
        String s = "AB-DE+F*/";
        System.out.println(postfix2Infix(s));
    }
}
