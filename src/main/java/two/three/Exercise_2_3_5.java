package two.three;

/* Give a code fragment that sorts an array that is known to consist of items having
   just two distinct keys. */
// My task: create recursion

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Random;

import static two.three.Exercise_2_3_8.exch;

// 1, 2, 1, 2
// 2, 1, 1, 2
// 2, 2, 1, 1

public class Exercise_2_3_5 {

    private static void sortTwoDistinctKeysArray(int[] a){
        int low = 0, greateValue = 0;
        boolean notDeterminedGreater = true;
        for (int i = 0; i < a.length - 1; i++) {
            if(notDeterminedGreater && a[i] > a[i + 1]){
                notDeterminedGreater = false;
                greateValue = a[i];
                exch(a, 0, i + 1);
                low = 0;
            } else if(notDeterminedGreater && a[i] < a[i + 1]){
                notDeterminedGreater = false;
                greateValue = a[i + 1];
            } else if(a[i] > a[i + 1]){
                low++;
                exch(a, i + 1, low);
            } else if(notDeterminedGreater && greateValue != a[i]){
                low++;
            }
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        int[] a = getRandomTwoDistinctKeysArray(10, r);
        //int[] a = {2, 2, 2, 2, 2, 1, 2, 2, 1, 2};
        printArr(a);
        sortTwoDistinctKeysArray(a);
        printArr(a);
        for (int i = 0; i < 100; i++) {
            int[] b = getRandomTwoDistinctKeysArray(20, r);
            sortTwoDistinctKeysArray(b);
            int[] copyB = Arrays.copyOf(b, b.length);
            boolean arraySorted = isArraySorted(b);
            if(!arraySorted){
                printArr(copyB);
            }
        }
    }

    private static boolean isArraySorted(int[] b) {
        for (int i = 0; i < b.length - 1; i++) {
            if(b[i] > b[i + 1]){
                return false;
            }
        }
        return true;
    }

    private static void printArr(int[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + ", ");
        }
        StdOut.println();
    }

    private static int[] getRandomTwoDistinctKeysArray(int n, Random r) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            if(r.nextBoolean()){
                a[i] = 1;
            } else {
                a[i] = 2;
            }
        }
        return a;
    }

    public static void sort(int[] a, int lo, int hi){
        if (hi <= lo) return;
        int lt = lo, i = lo+1, gt = hi;
        int v = a[lo];
        while (i <= gt) {
            int cmp = a[i] < (v) ? -1 : 1;
            if(a[i] == v) cmp = 0;
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        } // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
}
