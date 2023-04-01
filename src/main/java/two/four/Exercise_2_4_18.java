package two.four;

/* In MaxPQ, suppose that a client calls insert() with an item that is larger than all items in the queue,
and then immediately calls delMax(). Assume that there are no duplicate keys. Is the resulting heap identical
to the heap as it was before these operations? Answer the same question for two insert() operations
(the first with a key larger than all keys in the queue and the second for a key larger than that one) followed
by two delMax() operations. */

import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

public class Exercise_2_4_18 {
    public static void main(String[] args) {
        String[] a = {"E", "A", "S", "Q", "E", "S", "T", "I", "O", "N", "C", "B", "D", "F"};
        String[] b = getShuffledCopyOfArray(a);
        MaxPQ<String> queue = new MaxPQ<>(16);
        for (int i = 0; i <  b.length; i++) {
            queue.insert(b[i]);
        }
        printArray(queue);
        queue.insert("Y");
        queue.delMax();
        printArray(queue);
        StdOut.println();
        printArray(queue);
        queue.insert("U");
        queue.insert("Y");
        queue.delMax();
        queue.delMax();
        printArray(queue);
    }

    private static String[] getShuffledCopyOfArray(String[] a) {
        String[] b = new String[a.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[i];
        }
        Random r = new Random();
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if(i != j && r.nextBoolean()){
                    String temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }
        return b;
    }

    private static void printArray(MaxPQ<String> a){
        Comparable[] pq = a.getPq();
        for (int i = 0; i < a.size(); i++) {
            StdOut.print(pq[i] + ", ");
        }
        StdOut.println();
    }
}
