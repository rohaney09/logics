package logics.DSA;


public class QueueArray {
    int[] queue;
    int front;
    int rear;
    int size;

    public QueueArray(int size) {
        this.size = size;
        queue = new int[size];
        front = 0;
        rear = -1;   // queue is empty
    }

    // enqueue
    public void enqueue(int x) {
        if (rear == size - 1) {
            System.out.println("Queue Full");
            return;
        }
        queue[++rear] = x;
        System.out.println(x + "  enqueued");
    }

    // dequeue
    public int dequeue() {
        if (front > rear) {
            System.out.println("Queue Empty");
            return -1;
        }
        return queue[front++];  // move front forward
    }

    // peek
    public int peek() {
        if (front > rear) {
            System.out.println("Queue Empty");
            return -1;
        }
        return queue[front];
    }

    // is empty
    public boolean isEmpty() {
        return front > rear;
    }

    // main
    public static void main(String[] args) {
        QueueArray q = new QueueArray(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        System.out.println("Front: " + q.peek());
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Is Empty? " + q.isEmpty());
    }
}

