package three;

/*Interpolation search. Suppose that arithmetic operations are allowed on keys
(for example, they may be Double or Integer values). Write a version of binary search
that mimics the process of looking near the beginning of a dictionary when the word
begins with a letter near the beginning of the alphabet. Specifically, if kx is the key value
sought, klo is the key value of the first key in the table, and khi is the key value of the
last key in the table, look first ⎣(kx - klo)/(khi - klo)⎦-way through the table, not half-
way. Test your implementation against BinarySearchST for FrequencyCounter using
SearchCompare. */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
public class Exercise_3_1_24 {

    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        //        if (alg.equals("Merge")) Merge.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) { // Use alg to sort T random arrays of length N.
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) { // Perform one experiment (generate and sort an array).
            for (int i = 0; i < N; i++)
                a[i] = 1.1;//StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Insertion";
        String alg2 = "Shell";
        int N = Integer.parseInt("1500");
        int T = Integer.parseInt("1000");
        double t1 = timeRandomInput(alg1, N, T); // total for alg1
        double t2 = timeRandomInput(alg2, N, T); // total for alg2
        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);
    }
}
