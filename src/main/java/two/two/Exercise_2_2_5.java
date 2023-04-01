package two.two;

/*Give the sequence of subarray sizes in the merges performed by both the topdown
and the bottom-up mergesort algorithms, for N = 39.*/

import edu.princeton.cs.algs4.StdOut;
import java.util.Random;
import static two.Example.less;

public class Exercise_2_2_5 {
    private static int[] aux; // auxiliary array for merges

    public static void main(String[] args) {
        int[] a1 = getRandomArray();
        int[] a2 = getCopy(a1);
        sort(a1);
        StdOut.println();
        bottomUpMergeSort(a2);
    }

    public static void sort(int[] a) {
        aux = new int[a.length]; // Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    public static void bottomUpMergeSort(int[] a) { // Do lg N passes of pairwise merges.
        int N = a.length;
        aux = new int[N];
        for (int sz = 1; sz < N; sz = sz+sz) // sz: subarray size
            for (int lo = 0; lo < N-sz; lo += sz+sz) // lo: subarray index
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
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
        for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
            if (i > mid) a[k] = aux[j++];
            else if (j > hi ) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        printArr(a);
    }

    private static void printArr(int[] a) {
        for(int i = 0; i < a.length; i++){
            StdOut.print(a[i] + ", ");
        }
        StdOut.println();
    }
    private static int[] getRandomArray() {
        int[] a = new int[39];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(100);
        }
        return a;
    }

    private static int[] getCopy(int[] a) {
        int[] copyArray = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            copyArray[i] = a[i];
        }
        return copyArray;
    }
}
