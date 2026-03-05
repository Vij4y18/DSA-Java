package Linked_List_Singly_Med;

public class AddTwo {
    // Add Two Numbers
    private static Node addTwoNos (Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;

            Node newNode = new Node(sum%10);
            temp.next = newNode;
            temp = temp.next;
        }
        return dummy.next;
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
        int[] arr1 = {2,4,3};
        int[] arr2 = {5,6,4};
        Node l1 = convertToLl(arr1);
        Node l2 = convertToLl(arr2);
        print(l1);
        System.out.println();
        print(l2);
        System.out.println();
        print(addTwoNos(l1,l2));
    }
}
