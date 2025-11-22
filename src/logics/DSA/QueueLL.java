package logics.DSA;

public class QueueLL {

    static class Node {
        int data;
        Node next;
        Node(int d){ data = d; }
    }

    Node front = null, rear = null;

    public void enqueue(int x){
        Node n = new Node(x);
        if(rear == null){
            front = rear = n;
        } else {
            rear.next = n;
            rear = n;
        }
    }

    public int dequeue(){
        if(front == null){
            System.out.println("Queue Empty");
            return -1;
        }
        int val = front.data;
        front = front.next;
        if(front == null) rear = null;
        return val;
    }

    public static void main(String[] args){
        QueueLL q = new QueueLL();
        q.enqueue(10);
        q.enqueue(20);
        System.out.println(q.dequeue());
    }
}

