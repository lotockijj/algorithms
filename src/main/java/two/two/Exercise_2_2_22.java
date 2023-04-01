package two.two;

/* 3-way mergesort. Suppose instead of dividing in half at each step, you divide
into thirds, sort each third, and combine using a 3-way merge. What is the order of
growth of the overall running time of this algorithm? */
// Doesn't work !?

import edu.princeton.cs.algs4.StdOut;

public class Exercise_2_2_22 {
    private static int[] aux; // auxiliary array for merges

    public static void sort(int[] a) {
        aux = new int[a.length]; // Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) { // Sort a[lo..hi].
        if (hi <= lo) return;
        if(hi - lo == 1) {
            sortSmall(a, hi, lo);
            return;
        }
        int oneThird = lo + (hi - lo)/3;
        int twoThird = lo + 2*(hi - lo)/3;
        sort(a, lo, oneThird); // Sort left half.
        sort(a, oneThird + 1, twoThird); // Sort right half.
        sort(a, twoThird + 1, hi); // Sort right half.
        merge(a, lo, oneThird, twoThird, hi); // Merge results (code on page 271).
    }

    public static void merge(int[] a, int lo, int mid, int mid2, int hi) { // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid + 1, n = mid2 + 1;
        for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) { // Merge back to a[lo..hi].
            if (i > mid && n > hi) a[k] = aux[j++];
            else if (j > mid2 && n > hi) a[k] = aux[i++];
            else if (i > mid && n > hi) a[k] = aux[j++];
            else if (i > mid && j > mid2) a[k] = aux[n++];
            else if (less(aux[j], aux[i], aux[n])) a[k] = aux[j++];
            else if (less(aux[j], aux[i], aux[n])) a[k] = aux[j++];
            else if (less(aux[i], aux[j], aux[n])) a[k] = aux[i++];
            else if (less(aux[n], aux[i], aux[j])) a[k] = aux[n++];
            else if (i > mid + 1 && j > mid2 + 1) a[k] = aux[n++];
            else if (i > mid + 1 && n > hi) a[k] = aux[j++];
            else if (j > mid2 + 1 && n > hi) a[k] = aux[i++];
            if (n >= hi) {
                n--;
                aux[n] = Integer.MAX_VALUE;
            }
            if (i >= mid + 1) {
                i--;
                aux[i] = Integer.MAX_VALUE;
            }
            if (j >= mid2 + 1) {
                j--;
                aux[j] = Integer.MAX_VALUE;
            }
        }
    }

    private static void sortSmall(int[] a, int hi, int lo) {
        if(a[hi] < a[lo]){
            int temp = a[hi];
            a[hi] = a[lo];
            a[lo] = temp;
        }
    }

    public static boolean less(int first, int second, int third){
        if(first < second && first < third){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] a1 = { 4, -100, -5, 5, 6, 7, 10, 9};
        //int[] a2 = { -10, 3, 11, 22, -101, -201, -33, 22, 21, 17};
        //int[] a3 = { 106, -107, 108, -109, 110, -111, 112, 0};
        sort(a1);
        //sort(a2);
        //sort(a3);
        printIndexes(a1);
        //printIndexes(a2);
        //printIndexes(a3);
    }

    private static void printIndexes(int[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + ", ");
        }
        StdOut.println();
    }

}
