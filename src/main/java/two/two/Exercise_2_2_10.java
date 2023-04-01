package two.two;

/*Faster merge. Implement a version of merge() that copies the second half of
a[] to aux[] in decreasing order and then does the merge back to a[]. This change allows
you to remove the code to test that each of the halves has been exhausted from the
inner loop. Note: The resulting sort is not stable (see page 341). */

import edu.princeton.cs.algs4.StdOut;

import static two.Example.less;

public class Exercise_2_2_10 {
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
        sort(a, mid+1, hi); // Sort right half.
        merge(a, lo, mid, hi); // Merge results (code on page 271).
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        for (int i = lo; i <= mid; i++) {
            aux[i] = a[i];
        }
        for (int j = mid+1; j <= hi; j++) {
            aux[j] = a[hi - j + mid + 1];
        }
        int i = lo, j = hi;
        for (int k = lo; k <= hi; k++)
            if (less(aux[j], aux[i])) a[k] = aux[j--];
            else                      a[k] = aux[i++];
    }

    public static void main(String[] args) {
        String[] a = { "A", "E", "Q", "S", "U", "Y", "E", "I", "N", "O", "S", "T"};
        sort(a);
        printArr(a);
    }

    private static void printArr(Comparable[] a) {
        for(int i = 0; i < a.length; i++){
            StdOut.print(a[i] + ", ");
        }
        StdOut.println();
    }
}