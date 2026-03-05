package Linked_List_Singly_Med;

import java.util.HashMap;

public class DetectCycle {
    // Note : you can only run this code in leetcode because we cannot loop last node
    //Brute
    private static Boolean detectloopBrute(Node head) {
        HashMap<Node,Integer> mpp = new HashMap<>();
        Node temp = head;
        while(temp != null) {
            if(mpp.containsKey(temp)) {
                return true;
            }
            mpp.put(temp, mpp.getOrDefault(temp,1)+1);
            temp = temp.next;
        }
        return false;
    }

    private static Boolean detectloopOptimal(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
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
        System.out.println(detectloopOptimal(head));

    }
}
