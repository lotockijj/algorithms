package two.four;

/* What is the minimum number of items that must be exchanged during a remove the maximum operation
in a heap of size N with no duplicate keys? Give a heap of size 15 for which the minimum is achieved.
Answer the same questions for two and three successive remove the maximum operations. */
// I achieved result 2 !? For two it is 5 and for three it is 8, 11, 13, 16

import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

public class Exercise_2_4_14<Key extends Comparable<Key>> {
    private Key[] pq; // heap-ordered complete binary tree
    private int N = 0; // in pq[1..N] with pq[0] unused
    private static int numberOfExchangedItems = 0;

    public Exercise_2_4_14(int maxN) {
        pq = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1]; // Retrieve max key from top.
        exch(1, N--); // Exchange with last item.
        pq[N+1] = null; // Avoid loitering.
        sink(1); // Restore heap property.
        return max;
    }
    // See pages 145-147 for implementations of these helper methods.
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
        numberOfExchangedItems++;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public void sort() {
        for (int k = N/2; k >= 1; k--)
            sink(k);
        while (N > 1) {
            exch(1, N--);
            sink(1);
        }
    }

    public Key[] getPq(){
        return pq;
    }

    public static void main(String[] args) {
        int n = 15;
        int numberOfRehearsal = 1000;
        int result = Integer.MAX_VALUE;
//        for (int j = 0; j < numberOfRehearsal; j++) {
//            Double[] a = getRandomArray(n);
//            Exercise_2_14_4 exercise = new Exercise_2_14_4(n);
//            for (int i = 0; i < n; i++) {
//                exercise.insert(a[i]);
//            }
//            result = numberOfExchangedItems < result ? numberOfExchangedItems : result;
//            numberOfExchangedItems = 0;
//        }

        String[] strings = new String[n];
        for (int i = 0; i < numberOfRehearsal; i++) {
            String[] temp = getStringRandomArray(n);
            Exercise_2_4_14 exercise2144 = new Exercise_2_4_14(n);
            for (int j = 0; j < n; j++) {
                exercise2144.insert(temp[j]);
            }
            numberOfExchangedItems = 0;
            exercise2144.delMax();
            exercise2144.delMax();
            exercise2144.delMax();
            exercise2144.delMax();
            exercise2144.delMax();
            exercise2144.delMax();
            if(numberOfExchangedItems < result){
                result = numberOfExchangedItems;
                copyArray(exercise2144.getPq(), strings);
            }
            numberOfExchangedItems = 0;
        }
        StdOut.println(result);
        print(strings);
    }

    private static void reverstArr(String[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            String temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
    }

    public static void copyArray(Comparable[] pq, String[] strings) {
        for (int i = 0; i < pq.length; i++) {
            if(pq[i] != null) {
                strings[i] = pq[i].toString();
            }
        }
    }

    private static void print(String[] a){
        StdOut.println();
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + ", ");
        }
    }

    private static Double[] getRandomArray(int n) {
        Random r = new Random();
        Double[] a = new Double[n];
        for (int i = 0; i < n; i++) {
            a[i] = r.nextDouble();
        }
        return a;
    }

    private static String[] getStringRandomArray(int n){
        String[] a = {"A", "B", "C", "D", "E", "F", "G", "I", "J", "H", "K", "L", "V", "N", "O",
                "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        n = n > 26 ? 26 : n;
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

    private static void exch(String[] a, int i, int j){
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}