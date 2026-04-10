package Basics;

class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    // Constructor
    Stack(int size) {
        capacity = size;
        arr = new int[capacity];
        top = -1;
    }

    // Push operation
    public void push(int x) {
        if (top > arr.length) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
    }

    // Pop operation
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    // Peek (top element)
    public int top() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top];
    }

    // Size of stack
    public int size() {
        return top + 1;
    }

    // Display stack
    public void display() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class StackinArray {
    public static void main(String[] args) {

        Stack st = new Stack(5);

        // Push elements
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        // Display stack
        System.out.print("Stack: ");
        st.display();   // 40 30 20 10

        // Peek
        System.out.println("Top element: " + st.top()); // 40

        // Pop
        System.out.println("Popped: " + st.pop()); // 40
        System.out.println("Popped: " + st.pop()); // 30

        // Display after pop
        System.out.print("Stack after pop: ");
        st.display();   // 20 10

        // Size
        System.out.println("Size: " + st.size()); // 2



        // Fill stack to test overflow
        st.push(50);
        st.push(60);
        st.push(70); // should trigger overflow

        // Final display
        System.out.print("Final Stack: ");
        st.display();
    }
}
