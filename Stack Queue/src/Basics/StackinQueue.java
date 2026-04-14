package Basics;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q;

    // Constructor
    public MyStack() {
        q = new LinkedList<>();
    }

    // Push (costly)
    public void push(int x) {
        q.add(x);

        // Rotate elements
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
    }

    // Pop
    public int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return q.remove();
    }

    // Top
    public int top() {
        if (q.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return q.peek();
    }

    // Size
    public int size() {
        return q.size();
    }
}
public class StackinQueue {
    public static void main(String[] args) {
        MyStack st = new MyStack();

        st.push(10);
        st.push(8);
        st.push(12);

        System.out.println("Popped: " + st.pop()); // 12

        System.out.println("Top: " + st.top()); // 8

        st.push(5);

        System.out.println("Top after push(5): " + st.top()); // 5
        System.out.println("Size: " + st.size()); // 3
    }
}
