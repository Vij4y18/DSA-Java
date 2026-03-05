package Linked_List_Singly_Med;

import java.util.HashMap;

// In previous problem we returned true of false here we have to return the node where cycle begins
public class DetectCycle_II {
    // Note : you can only run this code in leetcode because we cannot loop last node
    //Brute O(N..) and space O(N) for hashmap
    private static Boolean detectCycleIIBrute(Node head) {
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

    // Optimal Takes O(N) Time and O(1) Space
    private static Node detectCycleIIOptimal(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    //Length of the cycle
    private static int detectCycleLength(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                int cnt = 1;
                fast = fast.next;
                while (slow != fast) {
                    fast = fast.next;
                    cnt++;
                }
                return cnt;
            }
        }
        return -1;
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
        Node cycle = head.next.next;
        mover.next = cycle;
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
        int[] arr = {1,2,3,3,4,5};
        Node head = convertToLl(arr);
//        print(head);
//        System.out.println();
//        head = detectCycleIIOptimal(head);
//        System.out.println(head.data);
        System.out.println(detectCycleLength(head));


    }
}
