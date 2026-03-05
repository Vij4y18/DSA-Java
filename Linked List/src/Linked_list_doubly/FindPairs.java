package Linked_list_doubly;

import java.util.ArrayList;
import java.util.List;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

// Given a Linked List find all the nodes that sums up to 'Sum';
public class FindPairs {
    // Brute approach is to use nested loop concept and check each & every value. Time = O(NxN)

    // Moving to optimal to optimise Time
    private static List findPairs(Node head, int sum) {
        List<Pair> ans = new ArrayList<>();
        Node left = head;
        Node right = head;
        while(right.next!=null) right = right.next;

        while(left.data < right.data) {
            if (left.data + right.data > sum) right = right.prev;
            else if (left.data + right.data < sum) left = left.next;
            else {
                ans.add(new Pair(left.data, right.data));
                right = right.prev;
                left = left.next;
            }
        }
        return ans;
    }
    // Creating a DLL
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
        int[] arr = {1,2,3,4,9};
        Node head = arrayToDll(arr);
        printLL(head);
        System.out.println();
        System.out.println(findPairs(head,5));
    }
}
