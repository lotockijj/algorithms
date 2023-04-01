package two.three;

/* Show, in the style of the trace given with partition(),
how that method patitions the array E A S Y Q U E S T I O N. */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import static two.Example.exch;
import static two.Example.less;

public class Exercise_2_3_1 {

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
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); // Put v = a[j] into position
        printArr(a);
        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
    }

    private static void printArr(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + ", ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        String[] a = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        sort(a);
        printArr(a);
    }
}