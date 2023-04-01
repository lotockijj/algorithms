package two.four.three;

import edu.princeton.cs.algs4.StdOut;
import two.four.MaxPQ;

public class Exercise_2_4_3 {

    public static void main(String[] args) {
        String[] a = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        MaxPQ<String> queue = new MaxPQ<>(12);
        processQueue(a, queue);
        String[] b = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        UnorderedArrayPriorityQueue<String> unorderedArrayPriorityQueue = new UnorderedArrayPriorityQueue<>(12);
        processQueue(b, unorderedArrayPriorityQueue);
        String[] c = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        LinkedListPriorityQueue linkedListPriorityQueue = new LinkedListPriorityQueue(12);
        processQueue(c, linkedListPriorityQueue);
    }

    private static void processQueue(String[] a, MaxPQ<String> queue) {
        for (int i = 0; i < a.length; i++) {
            queue.insert(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            StdOut.print(queue.delMax() + ", ");
        }
        StdOut.println();
    }

    private static void processQueue(String[] a, UnorderedArrayPriorityQueue<String> queue) {
        for (int i = 0; i < a.length; i++) {
            queue.insert(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
             StdOut.print(queue.delMax() + ", ");
        }
        StdOut.println();
    }

    private static void processQueue(String[] a, LinkedListPriorityQueue<String> queue) {
        for (int i = 0; i < a.length; i++) {
            queue.insert(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            StdOut.print(queue.delMax() + ", ");
        }
        StdOut.println();
    }

}
