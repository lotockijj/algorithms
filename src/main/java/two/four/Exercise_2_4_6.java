package two.four;

/* Using the conventions of Exercise 2.4.1, give the sequence of heaps produced when the operations
P R I O * R * * I * T * Y * * * Q U E * * * U * E are performed on an initially empty max-oriented heap */

import edu.princeton.cs.algs4.StdOut;

public class Exercise_2_4_6 {

    public static void main(String[] args) {
        String[] a = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        MaxPQ<String> queue = new MaxPQ<>(12);
        for (int i = 0; i < a.length; i++) {
            queue.insert(a[i]);
            printArray(queue);
        }
        for (int i = 0; i < a.length; i++) {
            queue.delMax();
            printArray(queue);
        }
    }

    private static void printArray(MaxPQ<String> a){
        Comparable[] pq = a.getPq();
        for (int i = 0; i < a.size(); i++) {
            StdOut.print(pq[i] + ", ");
        }
        StdOut.println();
    }
}
