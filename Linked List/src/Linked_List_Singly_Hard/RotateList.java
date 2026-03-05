package Linked_List_Singly_Hard;
 // Leet Code 61
public class RotateList {
    private static Node rotateList(Node head, int k) {
        if(head == null || head.next == null) return head;
        Node temp = head;
        int len = 1;
        while(temp.next != null) {
            temp = temp.next;
            len++;
        }
        k = k % len;
        if (k == 0) return head;
        temp.next = head;
        int newTail = len-k;
        for (int i=1; i<=newTail; i++) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;

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
         head = rotateList(head,2);
         print(head);

     }
}
