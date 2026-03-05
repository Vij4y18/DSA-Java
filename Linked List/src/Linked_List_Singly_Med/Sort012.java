package Linked_List_Singly_Med;

public class Sort012 {
    // Brute O(2N)
    private static Node sort1s2s0s (Node head) {
        int cnt0 = 0,cnt1 = 0, cnt2 = 0;
        Node temp = head;
        while(temp!=null) {
            if (temp.data == 0) cnt0++;
            else if (temp.data == 1) cnt1++;
            else cnt2++;

            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            if(cnt0>0) {
                temp.data = 0;
                cnt0--;
            } else if (cnt1 > 0) {
                temp.data = 1;
                cnt1--;
            } else {
                temp.data = 2;
                cnt2--;
            }
            temp = temp.next;
        }
        return head;
    }

    // Optimal O(N)
    private static Node Sort0s1s2s (Node head) {
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node l0 = zeroHead;
        Node l1 = oneHead;
        Node l2 = twoHead;
        Node temp = head;
        while(temp!=null) {
            if(temp.data == 0) {
                l0.next = temp;
                l0 = l0.next;
            } else if (temp.data == 1) {
                l1.next = temp;
                l1 = l1.next;
            } else {
                l2.next = temp;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        head = zeroHead.next;
        l0.next = (oneHead.next!=null) ? oneHead.next : twoHead.next;
        l1.next = twoHead.next;
        l2.next = null;
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
        int[] arr = {1,0,2,0,1,2,1};
        Node head = convertToLl(arr);
        print(head);
        System.out.println();
        head = Sort0s1s2s(head);
        print(head);
    }
}
