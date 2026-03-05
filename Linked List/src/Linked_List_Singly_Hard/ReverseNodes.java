package Linked_List_Singly_Hard;


public class ReverseNodes {
    private static Node findKthElement(Node temp, int k) {
        while (temp != null && k > 1) {
            temp = temp.next;
            k--;
        }
        return temp;
    }
    private static Node reverseKGroup(Node head, int k) {
        Node temp = head;
        Node prevNode = null;

        while(temp != null) {
            Node KthNode = findKthElement(temp,k);
            if (KthNode == null) {
                if (prevNode != null) prevNode.next = temp;
                break;
            }
            Node nextNode = KthNode.next;
            KthNode.next = null;
            reverse(temp);
            if (temp == head) {
                head = KthNode;
            } else {
                prevNode.next = KthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
    // Reverse Function
    private static Node reverse(Node head) {
        Node temp = head;
        Node backEl = null;
        Node frontEl = null;

        while(temp != null) {
            frontEl = temp.next;
            temp.next = backEl;
            backEl = temp;
            temp = frontEl;
        }
        return backEl;
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
        head = reverseKGroup(head,2);
        print(head);

    }
}
