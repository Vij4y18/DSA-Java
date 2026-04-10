package Basics;

class Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor
    Queue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Push (Enqueue)
    public void push(int x) {
        if (size == capacity) {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % capacity; // circular increment
        arr[rear] = x;
        size++;
    }

    // Pop (Dequeue)
    public int pop() {
        if (size == 0) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int val = arr[front];
        front = (front + 1) % capacity; // circular increment
        size--;
        return val;
    }

    // Top (Peek front element)
    public int top() {
        if (size == 0) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front];
    }

    // Size
    public int size() {
        return size;
    }
}

public class QueueinArray {
    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.push(10);
        q.push(20);
        q.push(30);

        System.out.println("Top: " + q.top()); // 10

        System.out.println("Popped: " + q.pop()); // 10
        System.out.println("Popped: " + q.pop()); // 20

        System.out.println("Top: " + q.top()); // 30

        System.out.println("Size: " + q.size()); // 1

        q.push(40);
        q.push(50);
        q.push(60);
        q.push(70); // overflow

        while (q.size() > 0) {
            System.out.print(q.pop() + " ");
        }
    }
}
