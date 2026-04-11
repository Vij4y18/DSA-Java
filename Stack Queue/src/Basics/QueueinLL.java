package Basics;

class QueueLL {

    // Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front; // remove from here
    private Node rear;  // insert here
    private int size;

    // Constructor
    QueueLL() {
        front = rear = null;
        size = 0;
    }

    // Push (Enqueue)
    public void push(int x) {
        Node newNode = new Node(x);

        if (rear == null) { // first element
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Pop (Dequeue)
    public int pop() {
        if (front == null) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int val = front.data;
        front = front.next;

        if (front == null) { // queue became empty
            rear = null;
        }

        size--;
        return val;
    }

    // Top (Peek front)
    public int top() {
        if (front == null) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return front.data;
    }

    // Size
    public int size() {
        return size;
    }
}

public class QueueinLL {
    public static void main(String[] args) {

        QueueLL q = new QueueLL();

        q.push(10);
        q.push(8);
        q.push(12);

        System.out.println("Popped: " + q.pop()); // 10

        System.out.println("Top: " + q.top()); // 8

        q.push(5);

        System.out.println("Top after push(5): " + q.top()); // 8
        System.out.println("Size: " + q.size()); // 3
    }
}
