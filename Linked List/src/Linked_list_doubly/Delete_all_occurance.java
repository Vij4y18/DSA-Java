package Linked_list_doubly;

public class Delete_all_occurance {
    // Deleting all the occurrence of a key in DLL
    private static Node delAllOccurrence(Node head,int target){
        if(head == null) return null;
        Node temp = head;

        while(temp != null && temp.data == target) {
            temp = temp.next;
        }
        if (temp == null) return null;

        head = temp;
        head.prev = null;

        while (temp != null) {
            if(temp.data == target) {
                if (temp.next != null) {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                } else {
                    temp.prev.next = null;
                }
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
        int[] arr = {10,12,10,5,10,8,10,9,10};
        Node head = arrayToDll(arr);
        printLL(head);
        System.out.println();
        head = delAllOccurrence(head,10);
        printLL(head);
    }
}
