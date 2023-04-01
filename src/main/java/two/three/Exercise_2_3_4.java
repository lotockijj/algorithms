package two.three;

/* Suppose that the initial random shuffle is omitted. Give six arrays of ten elements
for which Quick.sort() uses the worst-case number of compares. */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Exercise_2_3_4 {
    private static int numberOfCompares;

    public static void sort(int[] a) {
        //StdRandom.shuffle(a); // Eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); // Partition (see page 291).
        sort(a, lo, j-1); // Sort left part a[lo .. j-1].
        sort(a, j+1, hi); // Sort right part a[j+1 .. hi].
    }

    private static int partition(int[] a, int lo, int hi) { // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi+1; // left and right scan indices
        int v = a[lo]; // partitioning item
        while (true) { // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], v)) {
                if (i == hi) break;
            }
            while (less(v, a[--j])) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); // Put v = a[j] into position
        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
    }

    public static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean less(int v, int w) {
        numberOfCompares++;
        return v < w;
    }

//    public static void main(String[] args) {
//        int[] a = {7, 3, 9, 6, 4, 5, 2, 1, 8, 10};
//        sort(a);
//        StdOut.println(numberOfCompares);
//        numberOfCompares = 0;
//        int[] a1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        sort(a1);
//        StdOut.println(numberOfCompares);
//        numberOfCompares = 0;
//        int[] a2 = {10, 1, 8, 2, 6, 4, 5, 3, 7, 9};
//        sort(a2);
//        StdOut.println(numberOfCompares);
//        numberOfCompares = 0;
//        int[] a3 = {1, 2, 3, 4, 5, 6, 8, 7, 9, 10};
//        sort(a3);
//        StdOut.println(numberOfCompares);
//        numberOfCompares = 0;
//        int[] a4 = {1, 2, 3, 4, 5, 6, 7, 9, 8, 10};
//        sort(a4);
//        StdOut.println(numberOfCompares);
//        numberOfCompares = 0;
//        int[] a5 = {1, 2, 3, 4, 5, 6, 7, 8, 10, 9};
//        sort(a5);
//        StdOut.println(numberOfCompares);
//        numberOfCompares = 0;
//        int[] a6 = {2, 1, 3, 4, 5, 6, 7, 8, 9, 10};
//        sort(a6);
//        StdOut.println(numberOfCompares);
//    }

    public static void main(String[] args) {
        Exercise_2_3_4 exc = new Exercise_2_3_4();
        Result[] results = new Result[6];
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            Result res = exc.new Result();
            int[] a = getRandomArray(random);
            res.originalArray  = Arrays.copyOf(a, a.length);
            sort(a);
            res.sortedArray = a;
            res.numberOfCompares = numberOfCompares;
            numberOfCompares = 0;
            findAndAddResultWithBiggestNumberOfCompares(results, res);
        }
        printResults(results);
    }

    private static void findAndAddResultWithBiggestNumberOfCompares(Result[] results, Result res) {
        for (int i = results.length - 1; i >= 0; i--) {
            if(results[i] == null){
                results[i] = res;
                break;
            }
            if(results[i] != null &&
                    results[i].numberOfCompares > res.numberOfCompares &&
                    areArraysDifferent(results[i].sortedArray, res.sortedArray)){
                results[i] = res;
            }
        }
        sortResults(results);
    }

    private static void sortResults(Result[] results) {
        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < results.length; j++) {
                if(Objects.nonNull(results[i]) &&
                        Objects.nonNull(results[j]) &&
                        i != j && results[i].numberOfCompares > results[j].numberOfCompares){
                    Result temp = results[i];
                    results[i] = results[j];
                    results[j] = temp;
                }
            }
        }
    }

    private static boolean areArraysDifferent(int[] a, int[] b) {
        return !Arrays.equals(a,b);
    }

    private static int[] getRandomArray(Random random){
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        int nextInt = random.nextInt(a.length);
        for (int i = 0; i < nextInt; i++) {
            int nextInt1 = random.nextInt(a.length);
            int nextInt2 = random.nextInt(a.length);
            if(nextInt1 != nextInt2){
                int temp = a[nextInt1];
                a[nextInt1] = a[nextInt2];
                a[nextInt2] = temp;
            }
        }
        if(random.nextBoolean()) {
            StdRandom.shuffle(a);
        }
        return a;
    }

    public class Result{
        public int numberOfCompares;
        public int[] sortedArray;
        public int[] originalArray;
    }

    private static void printResults(Result[] results) {
        for (int i = 0; i < results.length; i++) {
            String str = "";
            if(Objects.nonNull(results[i])) {
                for (int j = 0; j < results[i].sortedArray.length; j++) {
                    str += results[i].originalArray[j] + ", ";
                }
                StdOut.println("Number of compares : " + results[i].numberOfCompares +
                        ". For list : " + str);
            }
        }
    }
}