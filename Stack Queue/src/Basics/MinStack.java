package Basics;
import java.util.Stack;

class pair {
    int val;
    int min;

    pair(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

class MinStackBrute {

    Stack<pair> st;

    public MinStackBrute() {
        st = new Stack<>();
    }

    public void push(int val) {
        if(st.isEmpty()) {
            st.push(new pair(val,val));
        } else {
            int currMin = Math.min(val,st.peek().min);
            st.push(new pair(val,currMin));
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().val;
    }

    public int getMin() {
        return st.peek().min;
    }
}


class MinStackOptimal {

    Stack<Long> st;
    long min;

    public MinStackOptimal() {
        st = new Stack<>();
    }

    public void push(int val) {
        long v = val;

        if (st.isEmpty()) {
            st.push(v);
            min = v;
        } else {
            if (v >= min) {
                st.push(v);
            } else {
                st.push(2 * v - min); // encoded value
                min = v;
            }
        }
    }

    public void pop() {
        if (st.isEmpty()) return;

        long x = st.pop();

        if (x < min) {
            min = 2 * min - x; // restore previous min
        }
    }

    public int top() {
        long x = st.peek();

        if (x >= min) return (int)x;
        else return (int)min;
    }

    public int getMin() {
        return (int)min;
    }
}

public class MinStack {
    public static void main(String[] args) {
        MinStackOptimal st = new MinStackOptimal();

        st.push(8);
        st.push(9);
        st.push(11);
        System.out.println(st.getMin());

    }
}
