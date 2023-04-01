package two.three;

/* Ignore small subarrays. Run experiments to compare the following strategy for dealing with
small subarrays with the approach described in Exercise 2.3.25: Simply ignore the small subarrays
in quicksort, then run a single insertion sort after the quick sort completes.
Note : You may be able to estimate the size of your computer’s cache memory with these experiments,
as the performance of this method is likely to degrade when the array does not fit in the cache. */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_2_3_27 {

    public static void sort(int[] a) {
        StdRandom.shuffle(a); // Eliminate dependence on input.
        sort(a, 0, a.length - 1);
        insertionSort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        if(lo + 10 <= hi) {
//            int m = medianOf3(a, lo, lo + (hi - lo)/2, hi);
//            exch(a, lo, m);
            int j = partition(a, lo, hi); // Partition (see page 291).
            sort(a, lo, j - 1); // Sort left part a[lo .. j-1].
            sort(a, j + 1, hi); // Sort right part a[j+1 .. hi].
        }
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

    public static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean less(int v, int w) {
        return v < w;
    }

    private static int[] getRandomArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        StdRandom.shuffle(a);
        return a;
    }

    public static void insertionSort(int a[], int left, int right) {
        int j;
        for (int p = left; p < right + 1; p++) {
            int tmp = a[p];
            for(j = p; j > 0 && tmp < a[j - 1]; j--) {
                a[j] = a[j-1];
            }
            a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = getRandomArray(1000);
        printArray(a);
        sort(a);
        printArray(a);
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + ", ");
        }
        StdOut.println();
    }
}
