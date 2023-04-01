package two.five;

// Implement a recursive version of select().

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import two.three.Exercise_2_3_11;

public class Exercise_2_5_6 {

    public static Comparable select(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int j = Exercise_2_3_11.partition(a, lo, hi);
            if (j == k) return a[k];
            else if (j > k) hi = j - 1;
            else if (j < k) lo = j + 1;
        }
        return a[k];
    }

    public static void main(String[] args) {
        String[] a = {"duplicate", "all", "many", "Three", "one", "two", "two", "Three", "Three", "duplicate"};
        Comparable c = select(a, 8);
        StdOut.println(c);
    }
}
