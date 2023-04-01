package two.three;

/* Suppose that we scan over items with keys equal to the partitioning item’s key instead
of stopping the scans when we encounter them. Show that the running time of this version
of quicksort is quadratic for all arrays with just a constant number of distinct keys. */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import static two.Example.exch;
import static two.Example.less;

public class Exercise_2_3_11 {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // Eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); // Partition (see page 291).
        sort(a, lo, j-1); // Sort left part a[lo .. j-1].
        sort(a, j+1, hi); // Sort right part a[j+1 .. hi].
    }

    public static int partition(Comparable[] a, int lo, int hi) { // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi+1; // left and right scan indices
        Comparable v = a[lo]; // partitioning item
        while (true) { // Scan right, scan left, check for scan complete, and exchange.
            while (i < a.length - 1 && less(a[++i], v)) if (i == hi) break;
            while (j > 0 && less(v, a[--j])) if (j == lo) break;
            if (i > j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); // Put v = a[j] into position
        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
    }

    public static void main(String[] args) {
        Double[] a = {3.0, 5.0, 1.0, 7.0, 2.0, 4.0, 9.0, 8.0, 6.0, 3.0, 5.0, 1.0, 7.0, 2.0, 4.0, 9.0, 8.0, 6.0};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + ", ");
        }
    }
}