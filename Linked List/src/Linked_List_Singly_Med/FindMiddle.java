package Linked_List_Singly_Med;

public class FindMiddle {
    // Brute approach is to iterate list and store cnt of elements
    // Then traverse again till cnt/2+1aand return it as head
    // Time is O(n + n/2) so need to optimise

    //Optimal
    private static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast !=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
        int[] arr = {1,2,3,4,5};
        Node head = convertToLl(arr);
        print(head);
        System.out.println();
        head = middleNode(head);
        print(head);

    }
}
