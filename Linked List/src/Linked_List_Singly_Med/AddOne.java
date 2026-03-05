package Linked_List_Singly_Med;
// Given the head of a singly linked list representing a positive integer number.
// Each node of the linked list represents a digit of the number, with the 1st node containing the leftmost digit of the number and so on.
// The task is to add one to the value represented by the linked list and return the head of a linked list containing the final value.

public class AddOne {
    // Iterative Method
    private static Node addOneIterative (Node head) {
        Node rev = reverse(head);
        Node temp = rev;
        int carry = 1;
        while (temp != null) {
            int digit = temp.data;
            if (digit + carry > 9) {
                temp.data = 0;
            } else {
                temp.data = digit + carry;
                carry--;
            }
            if (carry == 0) break;
            temp = temp.next;
        }
        head = reverse(rev);
        if (carry == 1) {
            Node newHead = new Node(1,head);
            return newHead;
        }
        return head;
    }

    // Recursive Method
    private static Node addOneRecursive (Node head) {
        int carry = func(head);
        if(carry == 1) {
            Node newNode = new Node(1,head);
            return newNode;
        }
        return head;
    }

    private static int func(Node head) {
        if(head == null) {
            return 1;
        }
        int carry = func(head.next);
        if (carry == 0) return 0;
        if (head.data + carry > 9) {
            head.data = 0;
            return 1;
        } else {
            head.data = head.data + carry;
            return 0;
        }
    }

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
        int[] arr = {7,9,9};
        Node head = convertToLl(arr);
        print(head);
        System.out.println();
        head = addOneRecursive(head);
        print(head);

    }
}
