package Linked_List_Singly_Med;

import java.util.ArrayList;
import java.util.Collections;

public class SortLL {
    // Brute takes O(2N) Time and O(N) Space
    private static Node sortLL1(Node head) {
        ArrayList<Integer> li = new ArrayList<>();
        Node temp = head;
        while(temp!=null) {
           li.add(temp.data);
           temp = temp.next;
        }
        Collections.sort(li);
        temp = head;
        int i = 0;
        while(temp!=null) {
            temp.data = li.get(i);
            temp = temp.next;
            i++;
        }
        return head;
    }

    // Implementing Merge Sort
    private static Node mergeSort (Node head) {
        if(head == null || head.next == null) return head;

        Node mid = middle(head);
        Node leftHead = head;
        Node rightHead = mid.next;
        mid.next = null;

        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);

        return merge(leftHead,rightHead);
    }


    // Helper function to find Middle element of a linked list
    private static Node middle(Node head) {
        Node slow = head;
        Node fast = head.next;
        while(fast !=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper function to merge two sorted list
    private static Node merge(Node left,Node right) {
        Node dummy = new Node(-1);
        Node temp = dummy;

        while (left != null && right != null) {
            if(left.data <= right.data) {
                temp.next = left;
                temp = temp.next;
                left = left.next;
            } else {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }
        if(left != null) temp.next = left;
        else temp.next = right;

        return dummy.next;
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
        int[] arr = {4,2,1,3};
        Node head = convertToLl(arr);
        print(head);
        System.out.println();
        head = mergeSort(head);
        print(head);
    }
}
