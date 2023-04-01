package two.four;

// For N=32, give arrays of items that make heapsort use as many and as few compares as possible.

import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

public class Exercise_2_4_16 <Key extends Comparable<Key>> {
    private static int numberOfCompares = 0;

    public static void main(String[] args) {
        int numberOfRehearsal = 1000;
        Exercise_2_4_16 exercise_2_4_16 = new Exercise_2_4_16();
        int result = Integer.MAX_VALUE;
        String[] strResult = new String[32];
        for (int i = 0; i < numberOfRehearsal; i++) {
            String[] strings = getStringRandomArray(32);
            exercise_2_4_16.sort(strings);
            if(numberOfCompares < result){
                result = numberOfCompares;
                Exercise_2_4_14.copyArray(strings, strResult);
            }
            numberOfCompares = 0;
        }
        StdOut.println("Z1".compareTo("Z2"));
        StdOut.println("Z1".compareTo("A"));
        StdOut.println("A".compareTo("Z1"));
        StdOut.println("Z1".compareTo("Z1"));
        StdOut.println("Z1".compareTo("Y"));
        StdOut.println(result);
        printArr(strResult);
    }

    public static void sort(String[] a) {
        int N = a.length;
        for (int k = N/2; k >= 1; k--)
            sink(a, k, N);
        while (N > 1) {
            exch(a, 1, --N);
            sink(a, 1, N);
        }
    }

    private static String[] getStringRandomArray(int n){
        String[] a = {"A", "B", "C", "D", "E", "F", "G", "I", "J", "H", "K", "L", "M", "N", "O",
                "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "Z1", "Z2", "Z3", "Z4", "Z5", "Z6", "Z7", "Z8"};
        //n = n > 26 ? 26 : n;
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = a[i];
        }
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int nextInt = r.nextInt(n);
            if(i != nextInt){
                exch(result, i, nextInt);
            }
        }
        return result;
    }

    private static void exch(String[] a, int i, int nextInt) {
        String temp = a[i];
        a[i] = a[nextInt];
        a[nextInt] = temp;
    }

    private static void sink(String[] a, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(a, j, j+1)) j++;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    private static boolean less(String[] a, int k, int j) {
        numberOfCompares++;
        if(j >= a.length) return false;
        int i = a[k].compareTo(a[j]);
        if(i == 0) return false;
        if(i > 0) return false;
        return true;
    }

    private static void printArr(String[] a){
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + ", ");
        }
    }


}