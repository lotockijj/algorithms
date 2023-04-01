package two.three;

/* Nuts and bolts. (G. J. E. Rawlins) You have a mixed pile of N nuts and N bolts
and need to quickly find the corresponding pairs of nuts and bolts. Each nut matches
exactly one bolt, and each bolt matches exactly one nut. By fitting a nut and bolt
together, you can see which is bigger, but it is not possible to directly compare two nuts
or two bolts. Give an efficient method for solving the problem. */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;
import java.util.Map;

import static two.three.Exercise_2_3_4.sort;

public class Exercise_2_3_15 {

    public static void main(String[] args) {
        int[] a = {17, 97, 47, 67, 57, 37, 87, 27, 77};
        int[] b = {38, 88, 28, 78, 18, 98, 48, 68, 58};
        int[] c = {17, 97, 47, 67, 57, 37, 87, 27, 77, 38, 88, 28, 78, 18, 98, 48, 68, 58};
        StdRandom.shuffle(c);
        sort(a);
        sort(b);
        Map<Integer, Integer> boltsAndNuts = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            boltsAndNuts.put(a[i], b[i]);
        }
        boltsAndNuts.entrySet().stream().forEach(entry -> {
            StdOut.println(entry.getKey() + " " + entry.getValue());
        });

    }
}
