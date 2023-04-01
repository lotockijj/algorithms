package two.two;

/*Inversions. Develop and implement a linearithmic algorithm for computing
the number of inversions in a given array (the number of exchanges that would be
performed by insertion sort for that array—see Section 2.1). This quantity is related
to the Kendall tau distance; see Section 2.5. */

import edu.princeton.cs.algs4.StdOut;

public class Exercise_2_2_19 {
    private static int numberOfInversion = 0;

    private static void sort(int[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if(a[j] < a[i]){
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                    numberOfInversion++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {-100, -10, -5, 1, 2, -20, 7, 6, 10, 9, 8};
        sort(a);
        printArr(a);
        StdOut.print("\n" + "Number of inversions: " + numberOfInversion);
    }

    private static void printArr(int[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + ", ");
        }
    }
}
