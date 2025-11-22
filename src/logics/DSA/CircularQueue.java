package logics.DSA;

public class CircularQueue {
    int[] arr;
    int front, rear, size;

    public CircularQueue(int n){
        arr = new int[n];
        front = rear = -1;
        size = n;
    }

    public void enqueue(int x){
        if((rear + 1) % size == front){
            System.out.println("Queue Full");
            return;
        }
        if(front == -1) front = 0;
        rear = (rear + 1) % size;
        arr[rear] = x;
    }

    public int dequeue(){
        if(front == -1){
            System.out.println("Queue Empty");
            return -1;
        }
        int val = arr[front];
        if(front == rear) front = rear = -1;
        else front = (front + 1) % size;
        return val;
    }

    public static void main(String[] args){
        CircularQueue q = new CircularQueue(3);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.dequeue());
        q.enqueue(40);
    }
}

