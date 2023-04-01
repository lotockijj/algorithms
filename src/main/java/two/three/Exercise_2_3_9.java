package two.three;

/* Explain what happens when Quick.sort() is run on an array having items with just two distinct keys,
   and then explain what happens when it is run on an array having just three distinct keys. */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_2_3_9 {

    public static void sort(int[] a) {
        StdRandom.shuffle(a); // Eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); // Partition (see page 291).
        sort(a, lo, j-1); // Sort left part a[lo .. j-1].
        sort(a, j+1, hi); // Sort right part a[j+1 .. hi].
    }

    private static int partition(int[] a, int lo, int hi) { // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi+1; // left and right scan indices
        int v = a[lo]; // partitioning item
        while (true) { // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], v)) {
                if (i == hi) break;
            }
            while (less(v, a[--j])) {
                if (j == lo) break;
            }
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
        printArraySmall(a);
    }

    public static boolean less(int v, int w) {
        return v < w;
    }

    public static void main(String[] args) {
        int[] a = getArrayWithTwoDifferentKeys(24);
        int[] b = getArrysWithThreeDifferentKeys(24);
        sort(a);
        printArray(a);
        sort(b);
        printArray(b);
    }

    private static int[] getArrysWithThreeDifferentKeys(int n) {
        int[] a = new int[n];
        int count = 1;
        for (int i = 0; i < n; i++) {
            a[i] = count;
            count++;
            if (count == 4) {
                count = 1;
            }
        }
        return a;
    }

    private static int[] getArrayWithTwoDifferentKeys(int n) {
        int[] a = new int[n];
        int count = 1;
        for (int i = 0; i < n; i++) {
            a[i] = count;
            count++;
            if(count == 3){
                count = 1;
            }
        }
        return a;
    }

    private static void printArray(int[] a){
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + ", ");
        }
        StdOut.println();
        StdOut.println();
    }
    private static void printArraySmall(int[] a){
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + ", ");
        }
        StdOut.println();
    }
}
