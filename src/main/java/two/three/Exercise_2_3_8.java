package two.three;

/* About how many compares will Quick.sort() make when sorting an array of N items that are all equal? */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_2_3_8 {
    private static int numberOfCompares;

    public static void sort(int[] a) {
        StdRandom.shuffle(a); // Eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); // Partition (see page 291).
        sort(a, lo, j - 1); // Sort left part a[lo .. j-1].
        sort(a, j + 1, hi); // Sort right part a[j+1 .. hi].
    }

    private static int partition(int[] a, int lo, int hi) { // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi + 1; // left and right scan indices
        int v = a[lo]; // partitioning item
        while (true) { // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); // Put v = a[j] into position
        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
    }

    public static boolean less(int v, int w) {
        numberOfCompares++;
        return v < w;
    }

    public static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = getRandomArray(10);
        sort(a);
        StdOut.println(numberOfCompares);
        numberOfCompares = 0;
        int[] a1 = getRandomArray(100);
        sort(a1);
        StdOut.println(numberOfCompares);
        numberOfCompares = 0;
        int[] a2 = getRandomArray(1000);
        sort(a2);
        StdOut.println(numberOfCompares);
        numberOfCompares = 0;
        int[] a3 = getRandomArray(10000);
        sort(a3);
        StdOut.println(numberOfCompares);
        numberOfCompares = 0;
    }

    private static int[] getRandomArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = 1;
        }
        return a;
    }
}