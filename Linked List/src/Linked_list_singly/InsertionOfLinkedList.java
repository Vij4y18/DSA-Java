package Linked_list_singly;

public class InsertionOfLinkedList {
    // Inserting an element at Head
    private static Node insertHead(Node head) {
        Node newEl = new Node(0);
        newEl.next = head;
        // Node newEl = new Node(0,head);  // We can you this as well
        head = newEl;
        return head;
    }

    // Inserting an element at Tail
    private static Node insertTail(Node head, int val) {
        if(head == null) return new Node(val);
        Node temp = head;
        while(temp.next != null) temp = temp.next;
        Node newEl = new Node(val);
        temp.next = newEl;
        return head;
    }

    // Inserting a element at given position 'K'

    private static Node insertPostion(Node head, int val, int k) {
        if(head == null && k==1) return new Node(val);
        if (k==1) return new Node(val,head);
        Node temp = head;
        int cnt = 1;

        while(temp != null) {
            if (cnt == k-1) {
                Node newEl = new Node(val, temp.next);
                temp.next = newEl;
                break;
            }
            temp = temp.next;
            cnt++;
        }
        return head;
    }

    // Inserting element before the value X
    private static Node insertValue(Node head,int val,int x) {
        if (head == null) return null;
        if(head.data == x) return new Node(val,head);
        Node temp = head;
        Node prev = null;

        while(temp != null) {
            if(temp.data == x) {
                Node newEl = new Node(val,temp);
                prev.next = newEl;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    // Function to create a new Linked List
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
        int[] arr = {1,2,4,5,6};
        Node head = convertToLl(arr);
        print(head);
        System.out.println();
        head = insertValue(head,3,6);
        print(head);
    }
}
