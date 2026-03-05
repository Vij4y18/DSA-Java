package Linked_List_Singly_Hard;

import java.util.HashMap;

class RandomNode {
    int data;
    RandomNode next;
    RandomNode random;

    RandomNode(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
    RandomNode(int data, RandomNode next) {
        this.data = data;
        this.next = next;
        this.random = null;
    }
    RandomNode(int data, RandomNode next, RandomNode random) {
        this.data = data;
        this.next = next;
        this.random = random;
    }
}

public class CopyList {
    private static RandomNode cloneLLBrute(RandomNode head) {
        if (head == null) return null;

        HashMap<RandomNode, RandomNode> map = new HashMap<>();

        RandomNode temp = head;

        // Step 1: Create copy nodes and store mapping
        while (temp != null) {
            map.put(temp, new RandomNode(temp.data));
            temp = temp.next;
        }

        temp = head;

        // Step 2: Assign next and random pointers
        while (temp != null) {
            RandomNode copyNode = map.get(temp);

            copyNode.next = map.get(temp.next);       // may return null (OK)
            copyNode.random = map.get(temp.random);   // may return null (OK)

            temp = temp.next;
        }

        // Step 3: Return copied head
        return map.get(head);
    }

    private static RandomNode cloneLLOptimal (RandomNode head) {
        if(head == null) return head;

        RandomNode temp = head;
        while (temp != null) {
            RandomNode newNode = new RandomNode(temp.data,temp.next);
            temp.next = newNode;
            temp = temp.next.next;
        }
        temp = head;
        while (temp != null) {
            RandomNode copyNode = temp.next;
//            if (temp.random != null) {
//                copyNode.random = temp.random.next;
//            } else {
//                copyNode.random = null;
//            }
            copyNode.random = (temp.random!=null) ? temp.random.next : null;
            temp = temp.next.next;
        }

        RandomNode dummyNode = new RandomNode(-1);
        RandomNode res = dummyNode;
        temp = head;
        while (temp != null) {
            res.next = temp.next;
            res = res.next;
            temp.next = res.next;
            temp = temp.next;
        }

        return dummyNode.next;
    }

    // Print Function
    static void print(RandomNode head) {
        while (head != null) {
            System.out.print("Data: " + head.data);
            if (head.random != null) {
                System.out.print(", Random: " + head.random.data);
            } else {
                System.out.print(", Random: null");
            }
            System.out.println();
            head = head.next;
        }
    }

    public static void main(String[] args) {
        RandomNode head = new RandomNode(7);
        head.next = new RandomNode(14);
        head.next.next = new RandomNode(21);
        head.next.next.next = new RandomNode(28);

        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        System.out.println("Original Linked List:");
        print(head);

        RandomNode clonedList = cloneLLOptimal(head);

        System.out.println("\nCloned Linked List:");
        print(clonedList);
    }
}