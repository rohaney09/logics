package logics.DSA2;

// ConnectRopesMinCost.java
import java.util.*;

public class ConnectRopesMinCost {

    public static int minCost(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int r : ropes) pq.add(r);

        int cost = 0;

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            cost += a + b;
            pq.add(a + b);
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        System.out.println("Minimum Cost: " + minCost(ropes));
    }
}

