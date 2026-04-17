package Prefix_Infix_Postfix;

import java.util.Stack;

public class Infix2Postfix {
    static int priority (Character c) {
        if (c == '^') return 3;
        else if (c == '*' || c == '/') return 2;
        else if (c == '+' || c == '-') return 1;
        else return -1;
    }

    static String infix2Postfix (String s) {
        Stack<Character> st = new Stack<>();
        String ans = "";

        for (char i : s.toCharArray()) {
            if ((i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z') || (i >= '0' && i <= '9')) {
                ans+=i;
            } else if (i == '(') {
                st.push(i);
            } else if (i == ')') {
                while (!st.isEmpty() && st.peek() != '(' ) {
                    ans += st.peek();
                    st.pop();
                }
                st.pop();
            } else {
                while (!st.isEmpty() && priority(i) <= priority(st.peek())) {
                    ans += st.peek();
                    st.pop();
                }
                st.push(i);
            }
        }

        while (!st.isEmpty()) {
            ans += st.peek();
            st.pop();
        }

        return ans;
    }
    public static void main(String[] args) {
        String s = "a+b*(c^d-e)";
        System.out.println(infix2Postfix(s));
    }
}
