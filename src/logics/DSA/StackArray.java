package logics.DSA;

public class StackArray {
    int size;        // maximum size
    int top;         // index of top element
    int[] stack;     // array to store stack elements

    // constructor
    public StackArray(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    // push operation
    public void push(int x) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = x;
        System.out.println(x + " pushed");
    }

    // pop operation
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    // peek operation
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    // check empty
    public boolean isEmpty() {
        return top == -1;
    }

    // main method to test
    public static void main(String[] args) {
        StackArray s = new StackArray(5);

        System.out.println("Popped: " + s.pop());
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Top element: " + s.peek());
        System.out.println("Popped: " + s.pop());
        System.out.println("Popped: " + s.pop());

        System.out.println("Is Empty? " + s.isEmpty());
    }
}

