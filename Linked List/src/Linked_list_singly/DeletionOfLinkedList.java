package Linked_list_singly;

public class DeletionOfLinkedList {
    // Deleting Head of a linked list
    private static Node deleteHead(Node head) {
        if(head == null) return head;
        head = head.next;
        return head;
    }

    // Deleting Tail of a Linked List
    private static Node deleteTail(Node head) {
        if(head == null || head.next == null) return null;
        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    // Deleting a position of a Linked List (k = position)
    private static Node deletePosition(Node head, int k) {
        if (head == null) return head;
        if(k==1) {
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        int cnt = 0;

        while(temp != null) {
            cnt ++;
            if(cnt == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    //Deleting given Element from a LL
    private static Node deleteElement(Node head, int el) {
        if (head == null) return head;
        if(head.data == el) {
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;

        while(temp != null) {
            if(temp.data == el) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    // Making a LL to perform deletion operation
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
        int[] arr = {1,2,3,4,5,12};
        Node head = convertToLl(arr);
        print(head);
        System.out.println();
        head = deleteElement(head,12);
        print(head);
    }
}
