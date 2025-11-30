package logics.DSA2;

// InsertDeleteHeap.java
import java.util.*;

public class InsertDeleteHeap {
    ArrayList<Integer> heap = new ArrayList<>();

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i)   { return 2 * i + 1; }
    private int right(int i)  { return 2 * i + 2; }

    void insert(int val) {
        heap.add(val);
        int i = heap.size() - 1;

        while (i > 0 && heap.get(parent(i)) < heap.get(i)) {
            Collections.swap(heap, i, parent(i));
            i = parent(i);
        }
    }

    int deleteRoot() {
        if (heap.size() == 0) return -1;

        int root = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (heap.size() > 0) {
            heap.set(0, last);
            heapify(0);
        }
        return root;
    }

    void heapify(int i) {
        int largest = i;
        int l = left(i), r = right(i);

        if (l < heap.size() && heap.get(l) > heap.get(largest))
            largest = l;
        if (r < heap.size() && heap.get(r) > heap.get(largest))
            largest = r;

        if (largest != i) {
            Collections.swap(heap, i, largest);
            heapify(largest);
        }
    }

    public static void main(String[] args) {
        InsertDeleteHeap h = new InsertDeleteHeap();
        h.insert(10);
        h.insert(20);
        h.insert(5);

        System.out.println("Deleted Root: " + h.deleteRoot());
    }
}

