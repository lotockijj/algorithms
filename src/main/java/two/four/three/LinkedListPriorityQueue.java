package two.four.three;

import java.util.LinkedList;

public class LinkedListPriorityQueue<Key extends Comparable<Key>> {
    private LinkedList<Key> pq; // heap-ordered complete binary tree
    private int N = 1; // in pq[1..N] with pq[0] unused

    public LinkedListPriorityQueue(int maxN) {
        pq = new LinkedList<>();
    }

    public boolean isEmpty() {
        return pq.size() == 0;
    }

    public int size() {
        return pq.size();
    }

    public void insert(Key v) {
        pq.add(v);
        if(pq.size() == 1){
            pq.add(v);
        }
        swim(N);
        N++;
    }

    public Key delMax() {
        Key max = pq.get(1); // Retrieve max key from top.
        exch(1, --N); // Exchange with last item.
        pq.remove(N); // Avoid loitering.
        sink(1); // Restore heap property.
        return max;
    }
    // See pages 145-147 for implementations of these helper methods.
    private boolean less(int i, int j) {
        return pq.get(i).compareTo(pq.get(j)) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq.get(i);
        pq.set(i, pq.get(j));
        pq.set(j,  t);
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && j + 1 < pq.size() && less(j, j+1)) j++;
            if (j < pq.size() && !less(k, j)) break;
            if(j < pq.size()) exch(k, j);
            k = j;
        }
    }

    public void sort() {
        for (int k = N/2; k >= 1; k--)
            sink(k);
        while (N > 1) {
            exch(1, N--);
            sink(1);
        }
    }

}