package Basics;

class StackLL {

    // Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top; // head of LL
    private int size;

    // Constructor
    StackLL() {
        top = null;
        size = 0;
    }

    // Push
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Pop
    public int pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int val = top.data;
        top = top.next;
        size--;
        return val;
    }

    // Top (peek)
    public int top() {
        if (top == null) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return top.data;
    }

    // Size
    public int size() {
        return size;
    }
}

public class StackinLL {
    public static void main(String[] args) {
        StackLL st = new StackLL();

        st.push(10);
        st.push(8);
        st.push(12);

        System.out.println("Popped: " + st.pop()); // 12

        System.out.println("Top: " + st.top()); // 8

        st.push(5);

        System.out.println("Top after push(5): " + st.top()); // 5
        System.out.println("Size: " + st.size());
    }
}
