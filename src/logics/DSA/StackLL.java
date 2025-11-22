public class StackLL {
    static class Node {
        int data;
        Node next;
        Node(int d){ data = d; }
    }

    Node top = null;

    public void push(int x){
        Node n = new Node(x);
        n.next = top;
        top = n;
    }

    public int pop(){
        if(top == null){
            System.out.println("Empty Stack");
            return -1;
        }
        int val = top.data;
        top = top.next;
        return val;
    }

    public int peek(){
        return (top == null) ? -1 : top.data;
    }

    public static void main(String[] args){
        StackLL st = new StackLL();
        st.push(10);
        st.push(20);
        System.out.println(st.peek());
        System.out.println(st.pop());
    }
}
