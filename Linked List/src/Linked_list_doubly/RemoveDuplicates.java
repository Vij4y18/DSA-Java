package Linked_list_doubly;

// Given a Doubly Linked List (sorted) remove all the duplicate nodes
public class RemoveDuplicates {
    private static Node removeDuplicates(Node head) {
        if (head == null) return head;
        Node temp = head;

        while(temp!=null&&temp.next!=null) {
            Node nextEl = temp.next;
            while (nextEl != null && nextEl.data == temp.data) nextEl = nextEl.next;
            temp.next = nextEl;
            if (nextEl != null) {
                nextEl.prev = temp;
            }
            temp = temp.next;
        }
        return head;
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
        int[] arr = {1,1,2,2,2,3,3,3};
        Node head = arrayToDll(arr);
        printLL(head);
        System.out.println();
        head = removeDuplicates(head);
        printLL(head);
    }
}
