package Linked_List_Singly_Med;

import java.util.Stack;

public class ReverseList {
    // Brute O(2N)
    private static Node reverseBrute(Node head) {
        Node temp = head;
        Stack<Integer> stack = new Stack<>();
        while(temp!=null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while(temp!=null) {
            temp.data = stack.pop();
            temp = temp.next;
        }
        return head;
    }

    // Optimal O(N)
    private static Node reverseOptimal(Node head) {
        Node temp = head;
        Node backEl = null;
        Node frontEl = null;

        while(temp != null) {
            frontEl = temp.next;
            temp.next = backEl;
            backEl = temp;
            temp = frontEl;
        }
        return backEl;
    }

    private static Node reverseRecursion(Node head) {
        if(head == null || head.next == null) return head;

        Node newHead = reverseRecursion(head.next);
        Node frontEl = head.next;
        frontEl.next = head;
        head.next = null;
        return newHead;
    }

    // Creating a Linked list
    private static Node convertToLl(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;

        for(int i=1;i<arr.length;i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    // Function to print a LL
    static void print(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node head = convertToLl(arr);
        print(head);
        System.out.println();
        head = reverseOptimal(head);
        print(head);

    }
}
