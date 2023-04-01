package two.three;

/* Median-of-3 partitioning. Add median-of-3 partitioning to quicksort, as described in the text (see page 296).
   Run doubling tests to determine the effectiveness of the change. */
// Haven't done yet !? Done with the help of the internet :)

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercise_2_3_18 {

    public static void sort(int[] a) {
        StdRandom.shuffle(a); // Eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        if(lo + 10 <= hi) {
            int m = medianOf3(a, lo, lo + (hi - lo)/2, hi);
            exch(a, lo, m);
            int j = partition(a, lo, hi); // Partition (see page 291).
            sort(a, lo, j - 1); // Sort left part a[lo .. j-1].
            sort(a, j + 1, hi); // Sort right part a[j+1 .. hi].
        } else {
            insertionSort(a, lo, hi);
        }
    }

    public static int partition(int[] a, int lo, int hi) { // Partition into a[lo..i-1], a[i], a[i+1..hi].
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

    public static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean less(int v, int w) {
        return v < w;
    }

    public static int[] getRandomArray(int n) {
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

    public static double time(String alg, int[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Exercise_2_3_18")) Exercise_2_3_18.sort(a);
        if (alg.equals("Quick")) Quick.sort(a);
        if (alg.equals("Exercise_2_3_19")) Exercise_2_3_19.sort(a);
        if (alg.equals("Exercise_2_3_27")) Exercise_2_3_27.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) { // Use alg to sort T random arrays of length N.
        double total = 0.0;
        int[] a;
        for (int t = 0; t < T; t++) { // Perform one experiment (generate and sort an array).
            a = getRandomArray(N);//StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Exercise_2_3_18";
        String alg2 = "Quick";
        int N = Integer.parseInt("15000");
        int T = Integer.parseInt("10");
        double t1 = timeRandomInput(alg1, N, T); // total for alg1
        double t2 = timeRandomInput(alg2, N, T); // total for alg2
        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }

}