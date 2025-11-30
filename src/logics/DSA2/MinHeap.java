package logics.DSA2;

// MinHeap.java
import java.util.*;

public class MinHeap {
    ArrayList<Integer> heap = new ArrayList<>();

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i)   { return 2 * i + 1; }
    private int right(int i)  { return 2 * i + 2; }

    void insert(int val) {
        heap.add(val);
        int i = heap.size() - 1;

        while (i != 0 && heap.get(parent(i)) > heap.get(i)) {
            Collections.swap(heap, i, parent(i));
            i = parent(i);
        }
    }

    int removeMin() {
        if (heap.size() == 0) return -1;

        int root = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (heap.size() == 0) return root;

        heap.set(0, last);
        minHeapify(0);

        return root;
    }

    void minHeapify(int i) {
        int smallest = i;
        int l = left(i), r = right(i);

        if (l < heap.size() && heap.get(l) < heap.get(smallest))
            smallest = l;
        if (r < heap.size() && heap.get(r) < heap.get(smallest))
            smallest = r;

        if (smallest != i) {
            Collections.swap(heap, i, smallest);
            minHeapify(smallest);
        }
    }

    public static void main(String[] args) {
        MinHeap h = new MinHeap();
        h.insert(5);
        h.insert(3);
        h.insert(8);
        h.insert(1);

        System.out.println("Removed Min: " + h.removeMin());
    }
}
