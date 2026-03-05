package Linked_list_doubly;

import java.util.Stack;

public class Reverse_DLL {
    // Brute approach is to swap data which takes O(2N) time and O(N) space(stack)
    private static Node reverseDllBrute(Node head) {
        Node temp = head;
        Stack<Integer> st = new Stack<>();
        while (temp!=null) {
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp!=null) {
            temp.data = st.pop();
            temp = temp.next;
        }
        return head;
    }

    // Moving to optimal where time = O(N) and no extra space taken O(1)
    private static Node reverseDllOptimal(Node head) {
        if (head == null || head.next == null) return head;
        Node currEl = head;
        Node backEl = null;
        while(currEl != null) {
            backEl = currEl.prev;
            currEl.prev = currEl.next;
            currEl.next = backEl;
            currEl = currEl.prev; // Moving to next Node
        }
        head = backEl.prev;
        return head;
    }
    private static Node arrayToDll(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;

        for(int i=1;i<arr.length;i++) {
            Node temp = new Node(arr[i],null,mover);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    // Printing Linked List
    private static void printLL(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node head = arrayToDll(arr);
        printLL(head);
        System.out.println();
        head = reverseDllOptimal(head);
        printLL(head);
    }
}
