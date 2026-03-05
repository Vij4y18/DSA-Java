package Linked_list_singly;

class Node {
    int data;
    Node next;

    Node (int data1, Node next1) {
        data = data1;
        next = next1;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
