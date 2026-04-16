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

public class MinStack {
    public static void main(String[] args) {
        MinStackBrute st = new MinStackBrute();

        st.push(8);
        st.push(9);
        st.push(11);
        System.out.println(st.getMin());

    }
}
