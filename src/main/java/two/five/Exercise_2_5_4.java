package two.five;

/* Implement a method String[] dedup(String[] a) that returns the objects in
   a[] in sorted order, with duplicates removed. */

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise_2_5_4 {
    public static void main(String[] args) {
        String[] a = {"duplicate", "all", "many", "Three", "one", "two", "two", "Three", "Three", "duplicate"};
        a = dedup(a);
        printArr(a);
    }


    private static String[] dedup(String[] a) {
        Arrays.sort(a);
        String[] b = new String[a.length];
        int numberOfDuplicates = 0;
        for (int i = 0; i < a.length; i++) {
            if(i + 1 < a.length && a[i].equals(a[i + 1])){
                numberOfDuplicates++;
            } else {
                b[i] = a[i];
            }
        }
        String[] c = new String[b.length - numberOfDuplicates];
        int j = 0;
        for (int i = 0; i < b.length; i++) {
            if(b[i] != null){
                c[j] = b[i];
                j++;
            }
        }
        return c;
    }

    private static void printArr(String[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

}
