package two.three;

/* Write a program to compute the exact value of CN, and compare the exact value
with the approximation 2N ln N, for N = 100, 1,000, and 10,000
 My computing !?
 100 -> 921
 1000 -> 13815
 10000 -> 184206
 100000 -> 2302585
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;

import static two.Example.exch;

public class Exercise_2_3_6 {
    private static int numberOfCompares;

    public static void main(String[] args) {
        Double[] a100 = getRandomArray(100);
        sort(a100);
        double first = 921;
        StdOut.println(first/numberOfCompares);
        numberOfCompares = 0;
        Double[] a1000 = getRandomArray(1000);
        sort(a1000);
        double second = 13815;
        StdOut.println(second/numberOfCompares);
        numberOfCompares = 0;
        Double[] a10000 = getRandomArray(10000);
        sort(a10000);
        double third = 184206;
        StdOut.println(third/numberOfCompares);
        numberOfCompares = 0;
        Double[] a100000 = getRandomArray(100000);
        sort(a100000);
        double forth = 2302585;
        StdOut.println(forth/numberOfCompares);
    }

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

    public static boolean less(Comparable v, Comparable w) {
        numberOfCompares++;
        return v.compareTo(w) < 0;
    }

    private static Double[] getRandomArray(int n) {
        Double[] a = new Double[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = r.nextDouble();
        }
        return a;
    }
}
