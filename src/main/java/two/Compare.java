package two;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;
import java.util.Collections;

public class Compare {

    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        InsertionSort.sort(a);
        return timer.elapsedTime();
    }

    public static Double[] timeRandomInput(int N) { // Use alg to sort T random arrays of length N.
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        Arrays.sort(a, Collections.reverseOrder());
        return a;
    }

    public static void main(String[] args) {
        Double[] a = timeRandomInput(10000);
        Stopwatch timerInsertionSort = new Stopwatch();
        InsertionSort.sort(a);
        double v1 = timerInsertionSort.elapsedTime();
        Arrays.sort(a, Collections.reverseOrder());
        Stopwatch timerSelecionSort = new Stopwatch();
        SelectionSort.sort(a);
        double v2 = timerSelecionSort.elapsedTime();
        System.out.println("Inversion sort is " + v1/v2 + " slower. " + "v1=" + v1 + "; " + "v2=" + v2);
    }
}
