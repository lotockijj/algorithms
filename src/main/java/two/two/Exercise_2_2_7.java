package two.two;

/*Show that the number of compares used by mergesort is monotonically increasing (C(N+1) > C(N) for all N > 0). */

import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

import static two.Example.less;

public class Exercise_2_2_7 {
    private static Comparable[] aux; // auxiliary array for merges
    private static int numberOfCompares;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length]; // Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) { // Sort a[lo..hi].
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid); // Sort left half.
        sort(a, mid + 1, hi); // Sort right half.
        merge(a, lo, mid, hi); // Merge results (code on page 271).
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) { // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi){
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])){
                a[k] = aux[j++];
            } else a[k] = aux[i++];
            numberOfCompares++;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 21; i++) {
            Double[] a = getRandomArray(i*10);
            sort(a);
            StdOut.print(numberOfCompares + ",  ");
            numberOfCompares = 0;
        }
    }

    private static Double[] getRandomArray(int size) {
        Double[] a = new Double[size];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextDouble();
        }
        return a;
    }
}