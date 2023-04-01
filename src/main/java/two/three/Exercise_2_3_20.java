package two.three;

/* Nonrecursive quicksort. Implement a nonrecursive version of quicksort based on a main loop
   where a subarray is popped from a stack to be partitioned, and the resulting subarrays are pushed
   onto the stack. Note : Push the larger of the subarrays onto the stack first,
   which guarantees that the stack will have at most lg N entries. */

// Haven't done yet !?

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

import static two.Example.less;

public class Exercise_2_3_20 {

    public static void main(String[] args) {
        int[] a = {34, 32, 43, 12, 11, 32, 22, 21, 32};
        System.out.println("Unsorted array : " + Arrays.toString(a));
        iterativeQsort(a);
        System.out.println("Sorted array : " + Arrays.toString(a));
    }

    public static void iterativeQsort(int[] a) {
        StdRandom.shuffle(a); // Eliminate dependence on input.
        Stack<Integer> stack = new Stack();
        stack.push(0);
        stack.push(a.length);
        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            if (end - start < 2) {
                continue;
            }
            int p = start + ((end - start) / 2);
            p = partition(a, p, start, end);
            stack.push(p + 1);
            stack.push(end);
            stack.push(start);
            stack.push(p);
        }
    }

    private static int partition(int[] a, int v, int lo, int hi) { // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi+1; // left and right scan indices
        //Comparable v = a[lo]; // partitioning item
        while (true) { // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exchInt(a, i, j);
        }
        exchInt(a, lo, j); // Put v = a[j] into position
        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
    }

    public static void exchInt(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}