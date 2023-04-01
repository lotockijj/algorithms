package two.two;

/*Sort-test improvement. Run empirical studies for large randomly ordered arrays to study
the effectiveness of the modification described in Exercise 2.2.8 for random data. In particular,
develop a hypothesis about the average number of times the test (whether an array is sorted) succeeds,
as a function of N (the original array size for the sort). */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import static two.Example.less;

public class Exercise_2_2_24 {
    private static Comparable[] aux; // auxiliary array for merges
    private static int numberOfSucceeded = 0;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length]; // Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) { // Sort a[lo..hi].
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid); // Sort left half.
        sort(a, mid+1, hi); // Sort right half.
        if(!less(a[mid], a[mid + 1])) {
            merge(a, lo, mid, hi); // Merge results (code on page 271).
            numberOfSucceeded++;
        }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) { // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
            if (i > mid) a[k] = aux[j++];
            else if (j > hi ) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            int n = 100*i*5;
            Double[] a = generateRandomArray(n);
            sort(a);
            StdOut.printf("Array of size %s , number of succeeded compares %s", n, numberOfSucceeded);
            System.out.println();
        }
    }

    private static Double[] generateRandomArray(int n) {
        Double[] a = new Double[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniform();
        return a;
    }
}
