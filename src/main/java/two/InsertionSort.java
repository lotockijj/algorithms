package two;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class InsertionSort {

    public static void sort(Double[] a){
        for(int i = 1; i < a.length; i++){
            for(int j = i; j > 0 && Example.less(a[j], a[j - 1]); j--){
                Double temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }

    public static void sort(int[] a){
        for(int i = 1; i < a.length; i++){
            for(int j = i; j > 0 && Example.less(a[j], a[j - 1]); j--){
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }

    public static void partialSort(int[] a, int lo, int hi){
        for(int i = lo + 1; i < hi; i++){
            for(int j = i; j > lo && Example.less(a[j], a[j - 1]); j--){
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
//        Double[] a = {-10.0, 0.0, 1.0, 2.0, 8.0, 3.0, 5.0, -5.0};
//        sort(a);
//        for (int i = 0; i < a.length; i++){
//            StdOut.print(a[i]);
//        }
//        String[] arr = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
//        //Show, in the style of the example trace with Algorithm 2.2, how insertion sort sorts the array
//        sort(arr);
        int[] a = getRandomArray(10);
        printArray(a);
        partialSort(a, 1, 9);
        printArray(a);
    }

    private static int[] getRandomArray(int n){
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        StdRandom.shuffle(a);
        return a;
    }

    private static int[] copyOfArray(int[] a){
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        return b;
    }

    public static void sort(String[] a){
        for(int i = 1; i < a.length; i++){
            for(int j = i; j > 0 && Example.less(a[j], a[j - 1]); j--){
                String temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
            printArray(a);
        }
    }

    private static void printArray(String[] a){
        for(int i = 0; i < a.length; i++){
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    private static void printArray(int[] a){
        for(int i = 0; i < a.length; i++){
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

}
