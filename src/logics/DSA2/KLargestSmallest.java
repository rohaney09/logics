package logics.DSA2;

// KLargestSmallest.java
import java.util.*;

public class KLargestSmallest {
    public static void main(String[] args) {
        int[] arr = {5, 12, 11, -1, 12};
        int k = 3;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int val : arr) {
            pq.add(val);
            if (pq.size() > k)
                pq.poll();
        }

        System.out.println(k + " Largest Elements: " + pq);
    }
}

