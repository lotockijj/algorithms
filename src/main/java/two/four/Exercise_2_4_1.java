package two.four;

/* Suppose that the sequence P R I O * R * * I * T * Y * * * Q U E * * * U * E (where a letter means insert
and an asterisk means remove the maximum) is applied to an initially empty priority queue.
Give the sequence of letters returned by the remove the maximum operations. */

import edu.princeton.cs.algs4.StdOut;

public class Exercise_2_4_1 {

    public static void main(String[] args) {
        String[] a = {"P", "R", "I", "O", "*", "R", "*", "*",
                "I", "*", "T", "*", "Y", "*", "*", "*", "Q", "U", "E", "*", "*", "*", "U", "*", "E"};
        MaxPQ<String> queue = new MaxPQ<>(20);
        for (int i = 0; i < a.length; i++) {
            if(a[i] != "*"){
                queue.insert(a[i]);
            } else {
                String str = queue.delMax();
                StdOut.print(str + ", ");
            }
        }

    }
}
