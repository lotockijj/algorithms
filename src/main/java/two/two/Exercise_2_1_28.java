package two.two;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercise_2_1_28 {
    public static double time(String alg, Integer[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) insertionSort(a);
        if (alg.equals("Selection")) selectionSort(a);
        return timer.elapsedTime();
    }

    public static void insertionSort(Integer[] a){
        for(int i = 1; i < a.length; i++){
            for(int j = i; j > 0 && a[j] < a[j - 1]; j--){
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }

    public static void selectionSort(Integer[] a){
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                if(a[j] < a[i]){
                    Integer temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }

    public static double timeRandomInput(String alg, int N, int T) { // Use alg to sort T random arrays of length N.
        double total = 0.0;
        Integer[] a = new Integer[N];
        for (int t = 0; t < T; t++) { // Perform one experiment (generate and sort an array).
            for (int i = 0; i < N; i++) {
                if(i%2 == 0) {
                    a[i] = 1;
                } else {
                    a[i] = 2;
                }
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Insertion";
        String alg2 = "Selection";
        int N = Integer.parseInt("500");
        int T = Integer.parseInt("1000");
        double t1 = timeRandomInput(alg1, N, T); // total for alg1
        double t2 = timeRandomInput(alg2, N, T); // total for alg2
        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }
}