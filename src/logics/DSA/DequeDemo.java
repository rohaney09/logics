package logics.DSA;

import java.util.*;

public class DequeDemo {
    public static void main(String[] args){
        Deque<Integer> dq = new ArrayDeque<>();

        dq.addFirst(10);
        dq.addLast(20);
        dq.addLast(30);

        System.out.println(dq.removeFirst());
        System.out.println(dq.removeLast());
    }
}

