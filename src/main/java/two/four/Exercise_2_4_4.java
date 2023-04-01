package two.four;

// Is an array that is sorted in decreasing order a max-oriented heap?
// Yes !! Proved by this exercise.

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise_2_4_4 {
    public static void main(String[] args) {
        int[] a = {1, 5, 3, 8, 4, 10, 2, 7, 6, 9};
        Arrays.sort(a);
        reverseArray(a);
        printArray(a);
        String[] aStr = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        Arrays.sort(aStr);
        reverseArray(aStr);
        printArray(aStr);
    }

    private static void reverseArray(int[] a) {
        for (int i = 0; i < a.length/2; i++) {
            int temp = a[i];
            a[i] = a[a.length - 1 -i];
            a[a.length - 1 - i] = temp;
        }
    }

    private static void reverseArray(String[] a) {
        for (int i = 0; i < a.length/2; i++) {
            String temp = a[i];
            a[i] = a[a.length - 1 -i];
            a[a.length - 1 - i] = temp;
        }
    }

    private static void printArray(String[] aStr) {
        for (int i = 0; i < aStr.length; i++) {
            StdOut.print(aStr[i] + ", ");
        }
        StdOut.println();
    }

    private static void printArray(int[] aStr) {
        for (int i = 0; i < aStr.length; i++) {
            StdOut.print(aStr[i] + ", ");
        }
        StdOut.println();
    }
}
