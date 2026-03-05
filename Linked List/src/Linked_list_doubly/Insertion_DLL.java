package Linked_list_doubly;

public class Insertion_DLL {
    // Inserting Element in Head;
    private static Node insertHead(Node head, int val) {
        Node newEl = new Node(val,head,null);
        head.prev = newEl;
        head = newEl;
        return head;
    }

    // Inserting Element Before Tail;
    private static Node insertTail(Node head, int val) {
        if(head == null) return new Node(val);
        Node temp = head;
        while(temp.next != null) temp = temp.next;
        Node newEl = new Node(val,temp,temp.prev);
        temp.prev.next = newEl;
        temp.prev = newEl;
        return head;
    }

    // Inserting at Kth position  ## K should be a valid position i.e. 1 <= K <= N
    private static Node insertKthPosition(Node head, int val, int k) {
        if (k == 1) {
            Node newEl = new Node(val,head,null);
            head.prev = newEl;
            head = newEl;
            return head;
        }
        Node temp = head;
        int cnt = 1;
        while(temp != null) {
            if(cnt == k) break;
            temp = temp.next;
            cnt++;
        }
        Node backEl = temp.prev;
        Node newEl = new Node(val,temp,temp.prev);
        temp.prev.next = newEl;
        temp.prev = newEl;

        return head;
    }

    // Inserting Element before Node
    static void insertBeforeNode(Node node, int val) {
        Node prev = node.prev;
        Node newNode = new Node(val, node, prev);

        if (prev != null) {
            prev.next = newNode;
        }

        node.prev = newNode;
    }


    // Creating Linked List
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
        int[] arr = {1,2,3,4,5};
        Node head = arrayToDll(arr);
        printLL(head);
        System.out.println();
        head = insertKthPosition(head,8,5);
        // insertBeforeNode(head.next,8);
        printLL(head);
    }
}
