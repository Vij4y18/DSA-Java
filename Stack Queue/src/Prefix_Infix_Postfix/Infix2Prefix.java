package Prefix_Infix_Postfix;

import java.util.Stack;

public class Infix2Prefix {

    static int priority (Character c) {
        if (c == '^') return 3;
        else if (c == '*' || c == '/') return 2;
        else if (c == '+' || c == '-') return 1;
        else return -1;
    }

    static String reverse (String s) {
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        s = str.toString();
        int i = 0;

        while (i<s.length()) {
            if (s.charAt(i) == ')') str.setCharAt(i,'(');
            else if (s.charAt(i) == '(') str.setCharAt(i,')');
            i++;
        }
        return str.toString();
    }

    static String infix2Prefix (String s) {
        s = reverse(s);
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
                if (i == '^') {
                    while (!st.isEmpty() && priority(i) <= priority(st.peek())) {
                        ans += st.peek();
                        st.pop();
                    }
                } else while (!st.isEmpty() && priority(i) < priority(st.peek())) {
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

        StringBuilder str = new StringBuilder(ans);
        str.reverse();
        return str.toString();
    }
    public static void main(String[] args) {
        String s = "(A+B)*c-D+f";
        System.out.println(infix2Prefix(s));
    }
}
