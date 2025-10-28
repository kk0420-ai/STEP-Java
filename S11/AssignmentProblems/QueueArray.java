import java.util.*;

public class QueueArray {
    int front = -1, rear = -1, size;
    int[] queue;

    QueueArray(int size) {
        this.size = size;
        queue = new int[size];
    }

    void enqueue(int val) {
        if (rear == size - 1) System.out.println("Queue Overflow");
        else {
            if (front == -1) front = 0;
            queue[++rear] = val;
        }
    }

    void dequeue() {
        if (front == -1 || front > rear) System.out.println("Queue Underflow");
        else System.out.println("Dequeued: " + queue[front++]);
    }

    void peek() {
        if (front == -1 || front > rear) System.out.println("Empty Queue");
        else System.out.println("Front: " + queue[front]);
    }

    void display() {
        if (front == -1 || front > rear) System.out.println("Empty Queue");
        else {
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++) System.out.print(queue[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueueArray q = new QueueArray(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        q.dequeue();
        q.peek();
        q.display();
    }
}
