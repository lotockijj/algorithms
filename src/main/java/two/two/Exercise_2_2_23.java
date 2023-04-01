package two.two;

/* Improvements. Run empirical studies to evaluate the effectiveness of each of the
three improvements to mergesort that are described in the text (see Exercise 2.2.11).
Also, compare the performance of the merge implementation given in the text with the
merge described in Exercise 2.2.10. In particular, empirically determine the best value
of the parameter that decides when to switch to insertion sort for small subarrays. */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import two.Example;
import two.Merge;

import static two.Example.less;

public class Exercise_2_2_23 {
    private static Double[] aux; // auxiliary array for merges

    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Exercise_2_2_23")) sort(a);
        if (alg.equals("Merge")) Merge.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) { // Use alg to sort T random arrays of length N.
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) { // Perform one experiment (generate and sort an array).
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    public static void sort(Double[] a) {
        aux = new Double[a.length]; // Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    private static void sort(Double[] a, int lo, int hi) { // Sort a[lo..hi].
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

    public static void merge(Double[] a, int lo, int mid, int hi) { // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
            if (i > mid) a[k] = aux[j++];
            else if (j > hi ) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
    }

    public static void insertionPartialSort(Double[] a, int start, int end){
        for(int i = start; i <= end; i++){
            for(int j = i; j > start && Example.less(a[j], a[j - 1]); j--){
                double temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        String alg1 = "Exercise_2_2_23";
        String alg2 = "Merge";
        int N = Integer.parseInt("1500");
        int T = Integer.parseInt("1000");
        double t1 = timeRandomInput(alg1, N, T); // total for alg1
        double t2 = timeRandomInput(alg2, N, T); // total for alg2
        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);
    }
}
