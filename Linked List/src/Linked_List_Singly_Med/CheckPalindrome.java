package Linked_List_Singly_Med;

import java.util.Stack;

public class CheckPalindrome {
    // Brute approach takes O(2N) time and O(N) space
    private static Boolean checkPalindrome1(Node head) {
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.data != st.pop()) return false;
            temp = temp.next;
        }
        return true;
    }

    // Optimal Approach takes O(N) time and O(1)
    private static Boolean checkPalindrome2(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHead = reverse(slow.next);
        Node first = head;
        Node second = secondHead;
        while (second!=null) {
            if(first.data != second.data) {
                reverse(secondHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    // Function to create a new Linked List
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

    // Helper function to reverse LL
    private static Node reverse(Node head) {
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

    // Function to print a LL
    static void print(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,4,3,2,1};
        Node head = convertToLl(arr);
        print(head);
        System.out.println();
        System.out.println(checkPalindrome2(head));

    }
}
