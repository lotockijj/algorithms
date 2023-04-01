package two.three;

/* Median-of-5 partitioning. Implement a quicksort based on partitioning on the median of a random
sample of five items from the subarray. Put the items of the sample at the appropriate ends of the array
so that only the median participates in partitioning. Run doubling tests to determine the effectiveness
of the change, in comparison both to the standard algorithm and to median-of-3 partitioning (see the previous exercise).
Extra credit : Devise a median-of-5 algorithm that uses fewer than seven compares on any input. */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import two.InsertionSort;

import static two.three.Exercise_2_3_18.timeRandomInput;

public class Exercise_2_3_19 {

    public static void sort(int[] a) {
        StdRandom.shuffle(a); // Eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        if(lo + 10 <= hi) {
            int m = medianOf5(a, lo, hi);
            exch(a, lo, m);
            int j = partition(a, lo, hi); // Partition (see page 291).
            sort(a, lo, j - 1); // Sort left part a[lo .. j-1].
            sort(a, j + 1, hi); // Sort right part a[j+1 .. hi].
        } else {
            insertionSort(a, lo, hi);
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

    private static int medianOf3(int[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ?
                (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
                (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
    }

    private static int medianOf5(int[] a, int lo, int hi) {
        int[] b = {a[lo], a[lo + 1], a[lo + 2], a[lo + 3], a[lo + 4]};
        InsertionSort.sort(b);
        a[lo] = b[0];
        a[lo + 1] = b[1];
        a[lo + 2] = b[2];
        a[lo + 3] = b[3];
        a[lo + 4] = b[4];
        return lo + 2;
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
        String alg1 = "Exercise_2_3_18";
        //String alg2 = "Exercise_2_3_19";
        String alg2 = "Exercise_2_3_27";
        int N = Integer.parseInt("150000");
        int T = Integer.parseInt("10");
        double t2 = timeRandomInput(alg2, N, T); // total for alg2
        double t1 = timeRandomInput(alg1, N, T); // total for alg1
        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }
}
