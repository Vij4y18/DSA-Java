package Linked_List_Singly_Med;

import java.util.HashMap;

public class IntersectionY {
    // Brute ; uses HashMap so Space = O(N -> (headA)) Time O(N1+N2)
    private static int intersectionBrute(Node headA, Node headB) {
        HashMap<Node, Integer> mpp = new HashMap<>();
        Node temp = headA;
        while(temp != null) {
            mpp.put(temp,1);
            temp = temp.next;
        }
        temp = headB;
        while(temp != null) {
            if(mpp.containsKey(temp)) return temp.data;
            temp = temp.next;
        }
        return -1;
    }

    // Better solution time = O(N1+N2(N1-N2) if Head A is bigger or O(N1+N2(N2-N1))
    private static int intersectionBetter(Node headA, Node headB) {
        int N1 = 0;
        int N2 = 0;
        Node temp = headA;
        while(temp != null) {
            N1++;
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            N2++;
            temp = temp.next;
        }
        if (N1>N2) {
            int common_point = N1-N2;
            temp = headA;
            while (common_point > 0) {
                temp = temp.next;
                common_point--;
            }
            headA = temp;
        } else {
            int common_point = N2-N1;
            temp = headB;
            while (common_point > 0) {
                temp = temp.next;
                common_point--;
            }
            headB = temp;
        }
        while (headA != null && headB != null) {
            if(headA == headB) return headA.data;
            headA = headA.next;
            headB = headB.next;
        }
        return -1;
    }

    // Optimal runs in O(M+N)
    private static Node intersectionOptimal(Node headA, Node headB) {
        if(headA == null || headB == null) return null;
        Node t1 = headA;
        Node t2 = headB;

        while(t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
            if (t1 == t2) return t1;
            if (t1 == null) t1 = headB;
            if (t2 == null) t2 = headA;
        }
        return t1;
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
        int[] arr1 = {8,6,4,9,12};
        int[] arr2 = {6,1,2};
        Node headA = convertToLl(arr1);
        Node headB = convertToLl(arr2);
        headB.next.next.next = headA.next.next;
        print(headA);
        System.out.println();
        print(headB);
        System.out.println();
        Node head = intersectionOptimal(headA,headB);
        print(head);
    }
}
