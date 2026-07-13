package Medium;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode (int data1, ListNode next1) {
        val = data1;
        next = next1;
    }

    ListNode(int data) {
        this.val = data;
        this.next = null;
    }
}

public class MergeKSortedList {

    static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (int i=0; i<lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            dummy.next = node;
            dummy = dummy.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return head.next;
    }

    public static void main(String[] args) {

        // List 1 : 1 -> 4 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        // List 2 : 1 -> 3 -> 4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // List 3 : 2 -> 6
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        // Array of heads
        ListNode[] lists = {l1, l2, l3};

        ListNode ans = mergeKLists(lists);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
        System.out.println();
    }
}
