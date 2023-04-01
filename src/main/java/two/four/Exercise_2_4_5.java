package two.four;

/* Give the heap that results when the keys E A S Y Q U E S T I O N are inserted
in that order into an initially empty max-oriented heap. */

import edu.princeton.cs.algs4.StdOut;

public class Exercise_2_4_5 {

    public static void main(String[] args) {
        String[] a = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        MaxPQ<String> queue = new MaxPQ<>(12);
        for (int i = 0; i < a.length; i++) {
            queue.insert(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            StdOut.print(queue.delMax() + ", ");
        }
    }

}
