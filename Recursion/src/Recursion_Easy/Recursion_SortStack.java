package Recursion_Easy;

import java.util.Stack;

public class Recursion_SortStack {
    static void insert(Stack<Integer> stack, int temp) {
        if (stack.isEmpty() || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }

        // Pop the top element and recursively insert
        int val = stack.pop();
        insert(stack, temp);

        // Push the popped element back
        stack.push(val);
    }

    static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            insert(stack, temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);

        sortStack(stack);
        System.out.print("Sorted stack (descending order): ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
