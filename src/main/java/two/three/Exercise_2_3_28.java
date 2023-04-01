package two.three;

/* Recursion depth. Run empirical studies to determine the average recursive
depth used by quicksort with cutoff for arrays of size M, when sorting arrays of N
distinct elements, for M=10, 20, and 50 and N = 10'3, 10'4, 10'5, and 10'6. */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import static two.Example.less;
import static two.three.Exercise_2_3_18.getRandomArray;

public class Exercise_2_3_28 {
    private static int recursionDepth;
    private static int sizeOfArray;

    public static void main(String[] args) {
        runTest(1000, 10);
        runTest(10000, 10);
        runTest(100000, 10);
        runTest(1000000, 10);
        runTest(1000, 20);
        runTest(10000, 20);
        runTest(100000, 20);
        runTest(1000000, 20);
        runTest(1000, 50);
        runTest(10000, 50);
        runTest(100000, 50);
        runTest(1000000, 50);
    }

    private static void runTest(int sizeOfArray, int cutOff) {
        int[] a = getRandomArray(sizeOfArray);
        sizeOfArray = cutOff;
        sort(a);
        StdOut.println("For size of array " + sizeOfArray + " and cutoff " + cutOff + " recursion depth " + recursionDepth);
        recursionDepth = 0;
    }

    public static void sort(int[] a) {
        StdRandom.shuffle(a); // Eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if(hi - lo - sizeOfArray > 0) recursionDepth++;
        if (hi <= lo) return;
        int j = partition(a, lo, hi); // Partition (see page 291).
        sort(a, lo, j-1); // Sort left part a[lo .. j-1].
        sort(a, j+1, hi); // Sort right part a[j+1 .. hi].
    }

    private static int partition(int[] a, int lo, int hi) { // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi+1; // left and right scan indices
        Comparable v = a[lo]; // partitioning item
        while (true) { // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exchInt(a, i, j);
        }
        exchInt(a, lo, j); // Put v = a[j] into position
        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
    }

    public static void exchInt(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
