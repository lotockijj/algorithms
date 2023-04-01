package two.two;

/*Shellsort increments. Run experiments to compare the increment sequence in
Algorithm 2.3 with the sequence 1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905, 8929,
16001, 36289, 64769, 146305, 260609 (which is formed by merging together the sequences
9·4k - 9·2k + 1 and 4k - 3·2k + 1). See Exercise 2.1.11.*/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Random;

import static two.Example.less;

public class Exercise_2_1_29 {

    public static void sort(double[] a, int[] sequence) { // Sort a[] into increasing order.
        int N = a.length;
        int step = sequence.length - 1;
        int h = sequence[sequence.length - 1];
        while (h >= 1) { // h-sort the array.
            for (int i = h; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h; j -= h) {
                    if(less(a[j], a[j-h])) {
                        double temp = a[j];
                        a[j] = a[j - h];
                        a[j - h] = temp;
                    } else {
                        break;
                    }
                }
                //StdOut.println("Number of compares divided by array size: " + sum/N);
            }
            step--;
            if(step < 0) {
                break;
            }
            h = sequence[step];
        }
    }

    public static void main(String[] args) {
        int[] sequence = {1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905, 8929, 16001, 36289, 64769, 146305, 260609};
        double[] a = randomArray();
        Stopwatch timer = new Stopwatch();
        sort(a, sequence);
        StdOut.println(timer.elapsedTime());
    }

    private static double[] randomArray(){
        double[] a = new double[500000];
        Random r = new Random();
        for(int i = 0; i < a.length; i++){
            a[i] = r.nextDouble();
        }
        return a;
    }
}
