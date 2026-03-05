package Linked_list_doubly;

public class Deletion_DLL {
    // Deleting Element on Head;
    private static Node deleteHead(Node head) {
        if(head == null || head.next == null) return null; // List is empty
        head = head.next;
        head.prev = null;
        return head;
    }

    // Deleting Element in tail;
    private static Node deleteTail(Node head) {
        if(head == null || head.next == null) return null; // List is empty
        Node temp = head;
        while(temp.next != null) temp = temp.next;
        temp.prev.next = null;
        return head;
    }

    // Deleting Kth position from Linked List
    private static Node deleteKthPosition(Node head,int k) {
        if(head == null) return null;

        Node temp = head;
        int cnt = 1;
        while(temp != null){
            if(cnt == k) break; // loop breaks when we reach position k & temp will be at K
            temp = temp.next;
            cnt++;
        }
        Node backEl = temp.prev; // Element before kth element;
        Node frontEl = temp.next; // Element after kth element;
        if(backEl ==null && frontEl == null) {
            return null;
        } else if (backEl == null) {
            return deleteHead(head);
        } else if (frontEl == null) {
            return deleteTail(head);
        } else {
            backEl.next = frontEl;
            frontEl.prev = backEl;
        }
        return head;
    }

    // Deleting a Value
    private static Node deleteValue(Node head,int val) {
        if(head == null) return null;

        Node temp = head;
        while(temp != null){
            if (temp.data == val) break;
            temp = temp.next;
        }
        Node backEl = temp.prev; // Element before kth element;
        Node frontEl = temp.next; // Element after kth element;
        if(backEl ==null && frontEl == null) {
            return null;
        } else if (backEl == null) {
            head = temp.next;
            head.prev = null;
            return head;
        } else if (frontEl == null) {
            temp.prev.next = null;
            return head;
        } else {
            backEl.next = frontEl;
            frontEl.prev = backEl;
        }
        return head;
    }


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
    private static void printLL(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,21,45};
        Node head = arrayToDll(arr);
        printLL(head);
        System.out.println();
        head = deleteValue(head,1);
        printLL(head);
    }
}
