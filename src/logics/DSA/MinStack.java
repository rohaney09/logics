package logics.DSA;

import java.util.*;

public class MinStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> minSt = new Stack<>();

    public void push(int x){
        st.push(x);
        if(minSt.isEmpty() || x <= minSt.peek())
            minSt.push(x);
    }

    public int pop(){
        if(st.isEmpty()) return -1;
        int val = st.pop();
        if(val == minSt.peek()) minSt.pop();
        return val;
    }

    public int getMin(){
        if(minSt.isEmpty()) return -1;
        return minSt.peek();
    }

    public static void main(String[] args){
        MinStack ms = new MinStack();
        ms.push(3); ms.push(5); ms.push(2); ms.push(2);

        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
    }
}

