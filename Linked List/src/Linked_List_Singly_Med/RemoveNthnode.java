package Linked_List_Singly_Med;

// Remove Nth node from the end;
public class RemoveNthnode {
    // Brute approach
    public static Node removeNthNode(Node head, int N) {
        int cnt = 0;
        Node temp = head;
        while(temp!=null) {
            cnt++;
            temp = temp.next;
        }
        if(cnt == N) return head.next; //Removing first Node
        cnt = cnt-N;  // traversing till the node before the nth node from last
        temp = head;
        while (cnt > 1) {
            cnt--;
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }

    // Optimal
    private static Node removeNthFromEnd(Node head, int n) {
        Node fast = head;
        Node slow = head;
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if(fast == null) return head.next;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
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
        head = removeNthFromEnd(head,2);
        print(head);
    }
}
