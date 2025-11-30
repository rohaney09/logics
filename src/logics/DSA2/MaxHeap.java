package logics.DSA2;

// MaxHeap.java
import java.util.*;

public class MaxHeap {
    ArrayList<Integer> heap = new ArrayList<>();

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i)   { return 2 * i + 1; }
    private int right(int i)  { return 2 * i + 2; }

    void insert(int val) {
        heap.add(val);
        int i = heap.size() - 1;

        while (i != 0 && heap.get(parent(i)) < heap.get(i)) {
            Collections.swap(heap, i, parent(i));
            i = parent(i);
        }
    }

    int removeMax() {
        if (heap.size() == 0) return -1;

        int root = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (heap.size() == 0) return root;

        heap.set(0, last);
        maxHeapify(0);

        return root;
    }

    void maxHeapify(int i) {
        int largest = i;
        int l = left(i), r = right(i);

        if (l < heap.size() && heap.get(l) > heap.get(largest))
            largest = l;
        if (r < heap.size() && heap.get(r) > heap.get(largest))
            largest = r;

        if (largest != i) {
            Collections.swap(heap, i, largest);
            maxHeapify(largest);
        }
    }

    public static void main(String[] args) {
        MaxHeap h = new MaxHeap();
        h.insert(10);
        h.insert(4);
        h.insert(15);
        h.insert(20);

        System.out.println("Removed Max: " + h.removeMax());
    }
}

