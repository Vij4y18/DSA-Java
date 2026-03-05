package Linked_List_Singly_Med;

public class RemoveMiddleNode {
    // Remove the middle Node from LL
    private static Node removeMid(Node head) {
        if(head == null || head.next == null) return null;
        Node fast = head;
        Node slow = head;
        Node prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = prev.next.next;
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
        head = removeMid(head);
        print(head);
    }
}
