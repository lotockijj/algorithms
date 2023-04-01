package two;

import edu.princeton.cs.algs4.StdOut;

import static two.Example.exch;
import static two.Example.less;

public class Shell {

    public static void sort(Comparable[] a) { // Sort a[] into increasing order.
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        while (h >= 1) { // h-sort the array.
            for (int i = h; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                double sum = 0;
                for (int j = i; j >= h; j -= h) {
                    if(less(a[j], a[j-h])) {
                        exch(a, j, j - h);
                    } else {
                        break;
                    }
                }
                //StdOut.println("Number of compares divided by array size: " + sum/N);
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {
        Double[] a = {-10.0, 0.0, 1.0, 2.0, 8.0, 3.0, 5.0, -5.0, -3.3, 2.2, 11.0, 22.0, 17.0, 23.0, -7.0, -6.0, -7.0};
        String[] arr = {"E", "A", "S", "Y", "S", "H", "E", "L", "L", "S", "O", "R", "T", "Q", "U", "E", "S", "T", "I", "O", "N"};
//        sort(a);
//        for (int i = 0; i < a.length; i++){
//            StdOut.println(a[i]);
//        }
        sort(arr);
        print(arr);
    }

    private static void print(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            StdOut.print(a[i]);
        }
    }
}
