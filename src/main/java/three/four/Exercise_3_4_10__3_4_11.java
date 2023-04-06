package three.four;

/* 3.4.10
Insert the keys E A S Y Q U T I O N in that order into an initially empty table
of size M =16 using linear probing. Use the hash function 11 k % M to transform the
k-th letter of the alphabet into a table index. Redo this exercise for M = 10.
 */

/* 3.4.11
Give the contents of a linear-probing hash table that results when you insert the
keys E A S Y Q U T I O N in that order into an initially empty table of initial size M
= 4 that is expanded with doubling whenever half full. Use the hash function 11 k % M
to transform the kth letter of the alphabet into a table index.
 */

import java.util.Arrays;
import java.util.Objects;

public class Exercise_3_4_10__3_4_11 {

    public static void main(String[] args) {
        /*LinearProbingHashST_3_4_10<String, Integer> linearProbingHashST_3_4_10 = fillSeparateChainingHashST(16);
        Object[] keys = linearProbingHashST_3_4_10.getKeys();
        Arrays.stream(keys).filter(Objects::nonNull).forEach(e -> System.out.print(e + ",  "));*/

        LinearProbingHashST_3_4_10<String, Integer> linearProbingHashST_3_4_11 = fillSeparateChainingHashST(4);
        Object[] keys2= linearProbingHashST_3_4_11.getKeys();
        Arrays.stream(keys2).filter(Objects::nonNull).forEach(e -> System.out.print(e + ",  "));
    }

    public static LinearProbingHashST_3_4_10<String, Integer> fillSeparateChainingHashST(int sizeOfHashSt) {
        LinearProbingHashST_3_4_10<String, Integer> linearProbingHashST_3_4_10 = new LinearProbingHashST_3_4_10<>(sizeOfHashSt);
        String[] strings = "S E A R C H X M P L".split(" ");
        for (int i = 0; i < strings.length; i++) {
            linearProbingHashST_3_4_10.put(strings[i], i);
        }
        return linearProbingHashST_3_4_10;
    }
}
