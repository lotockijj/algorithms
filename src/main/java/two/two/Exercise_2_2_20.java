package two.two;

/* Indirect sort. Develop and implement a version of mergesort that does not rearrange the array,
but returns an int[] array perm such that perm[i] is the index of the i th smallest entry in the array */
// Not finished !!


import edu.princeton.cs.algs4.StdOut;

import static two.Example.less;

public class Exercise_2_2_20 {
    private static int[] aux;
    private static int[] auxIndex;

    private static void sort(int[] a){
        aux = new int[a.length];
        auxIndex = new int[a.length];
        for (int i = 0; i < auxIndex.length; i++) {
            auxIndex[i] = i;
        }
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) { // Sort a[lo..hi].
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid); // Sort left half.
        sort(a, mid+1, hi); // Sort right half.
        merge(a, lo, mid, hi); // Merge results (code on page 271).
    }

    public static void merge(int[] a, int lo, int mid, int hi) { // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) { // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) { // Merge back to a[lo..hi].
            if (i > mid) {
                auxIndex[k] = j;
                a[k] = aux[j++];
            } else if (j > hi) {
                auxIndex[k] = i;
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                auxIndex[k] = j;
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
                auxIndex[k] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 4, -100, -5, 5, 6, 7, 10, 9};
        sort(a);
        printIndexes(auxIndex);
    }

    private static void printIndexes(int[] auxIndex) {
        for (int i = 0; i < auxIndex.length; i++) {
            StdOut.print(auxIndex[i] + ", ");
        }
    }
}
