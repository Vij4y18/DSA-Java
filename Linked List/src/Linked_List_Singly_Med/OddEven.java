package Linked_List_Singly_Med;

import java.util.ArrayList;

public class OddEven {
    private static Node oddEvenBrute(Node head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        ArrayList<Integer> li = new ArrayList<>();
        Node temp = head;

        while(temp != null && temp.next != null) {
            li.add(temp.data);
            temp = temp.next.next;
        }
        if(temp != null) li.add(temp.data);
        temp = head.next;
        while(temp != null && temp.next != null) {
            li.add(temp.data);
            temp = temp.next.next;
        }
        if(temp != null) li.add(temp.data);
        temp = head;
        int i=0;
        while(temp!=null){
            temp.data = li.get(i);
            temp=temp.next;
            i++;
        }
        return head;
    }

    // Optimal Solution takes O(N) and no extra space
    private static Node oddEven(Node head) {
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while(even != null && even.next!=null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
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
        head = oddEven(head);
        print(head);
    }
}
