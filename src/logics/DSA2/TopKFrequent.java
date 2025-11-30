package logics.DSA2;

// TopKFrequent.java
import java.util.*;

public class TopKFrequent {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for (int key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
            if (pq.size() > k)
                pq.poll();
        }

        System.out.print("Top " + k + " frequent: ");
        while (!pq.isEmpty())
            System.out.print(pq.poll()[0] + " ");
    }
}

