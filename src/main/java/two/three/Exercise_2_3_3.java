package two.three;

/* What is the maximum number of times during the execution of Quick.sort()
that the largest item can be exchanged, for an array of length N ? */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import static two.Example.less;

public class Exercise_2_3_3 {
    private static int largestItemCountExchanged;

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // Eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); // Partition (see page 291).
        sort(a, lo, j-1); // Sort left part a[lo .. j-1].
        sort(a, j+1, hi); // Sort right part a[j+1 .. hi].
    }

    private static int partition(Comparable[] a, int lo, int hi) { // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi+1; // left and right scan indices
        Comparable v = a[lo]; // partitioning item
        while (true) { // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); // Put v = a[j] into position
        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
    }

    public static void exch(Comparable[] a, int i, int j) {
        if(a[i] == "Y" || a[j] == "Y"){
            largestItemCountExchanged++;
        }
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        String[] a = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        for (int i = 0; i < 100; i++) {
            sort(a);
        }
        Double result = (0.0 + largestItemCountExchanged)/100;
        StdOut.println(result);
        largestItemCountExchanged = 0;
        sort(a);
        StdOut.println(largestItemCountExchanged);
    }
}