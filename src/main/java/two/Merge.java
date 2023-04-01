package two;

import edu.princeton.cs.algs4.StdOut;

import static two.Example.less;

public class Merge {
    private static Comparable[] aux; // auxiliary array for merges

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length]; // Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    public static void bottomUpMergeSort(Comparable[] a) { // Do lg N passes of pairwise merges.
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz+sz) // sz: subarray size
            for (int lo = 0; lo < N-sz; lo += sz+sz) // lo: subarray index
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
    }

    private static void sort(Comparable[] a, int lo, int hi) { // Sort a[lo..hi].
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid); // Sort left half.
        sort(a, mid + 1, hi); // Sort right half.
        merge(a, lo, mid, hi); // Merge results (code on page 271).
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
        String[] a1 = { "A", "E", "Q", "S", "U", "Y", "E", "I", "N", "O", "S", "T"};
        sort(a1);
        StdOut.println();
        String[] a2 = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O"};
        bottomUpMergeSort(a2);
    }

    private static void printArr(Comparable[] a) {
        for(int i = 0; i < a.length; i++){
            StdOut.print(a[i] + ", ");
        }
        StdOut.println();
    }
}
