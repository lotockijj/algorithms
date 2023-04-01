package two.two;

/* Implement the three improvements to mergesort that are described in the text
on page 275: Add a cutoff for small subarrays, test whether the array is
already in order, and avoid the copy by switching arguments in the recursive code.*/

import edu.princeton.cs.algs4.StdOut;
import two.Example;

import java.util.Random;
import static two.Example.less;

public class Exercise_2_2_11 {
    private static int[] aux; // auxiliary array for merges

    public static void sort(int[] a) {
        aux = new int[a.length]; // Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) { // Sort a[lo..hi].
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        if(mid - lo >= 15) {
            sort(a, lo, mid); // Sort left half.
        } else {
            insertionPartialSort(a, lo, mid);
        }
        if(hi - mid+1 >= 15) {
            sort(a, mid + 1, hi); // Sort right half.
        } else {
            insertionPartialSort(a, mid+1, hi);
        }
        if(!(a[mid] < a[mid + 1])) {
            merge(a, lo, mid, hi); // Merge results (code on page 271).
        }
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
    }

    public static void insertionPartialSort(int[] a, int start, int end){
        for(int i = start; i <= end; i++){
            for(int j = i; j > start && Example.less(a[j], a[j - 1]); j--){
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = getRandomArray(100);
        sort(a);
        printArr(a);
    }

    private static int[] getRandomArray(int length) {
        int[] a = new int[39];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(100);
        }
        return a;
    }

    private static void printArr(int[] a) {
        for(int i = 0; i < a.length; i++){
            StdOut.print(a[i] + ", ");
        }
        StdOut.println();
    }
}