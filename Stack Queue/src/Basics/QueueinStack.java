package Basics;

import java.util.Stack;

class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int top() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

public class QueueinStack {
    public static void main(String[] args) {
        MyQueue Q = new MyQueue();

        Q.push(10);
        Q.push(8);
        System.out.println(Q.pop());
        Q.push(12);
        System.out.println(Q.top());
        System.out.println(Q.empty());
    }
}
