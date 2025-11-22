package logics.DSA;

import java.util.*;

public class MonotoniStack {

    public static void monotonicInc(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int num : arr) {
            while (!st.isEmpty() && st.peek() > num) {
                st.pop();   // remove bigger elements
            }
            st.push(num);   // push current element
            System.out.println("Stack: " + st);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 2, 7};

        System.out.println("Monotonic Increasing Stack:");
        monotonicInc(arr);
    }
}

