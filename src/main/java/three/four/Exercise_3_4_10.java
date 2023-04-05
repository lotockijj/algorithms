package three.four;

/*
Insert the keys E A S Y Q U T I O N in that order into an initially empty table
of size M =16 using linear probing. Use the hash function 11 k % M to transform the
k-th letter of the alphabet into a table index. Redo this exercise for M = 10.
 */

import java.util.Arrays;
import java.util.Objects;

public class Exercise_3_4_10 {

    public static void main(String[] args) {
        LinearProbingHashST_3_4_10<String, Integer> linearProbingHashST_3_4_10 = fillSeparateChainingHashST();
        Object[] keys = linearProbingHashST_3_4_10.getKeys();
        Arrays.stream(keys).filter(Objects::nonNull).forEach(e -> System.out.print(e + ",  "));
    }

    public static LinearProbingHashST_3_4_10<String, Integer> fillSeparateChainingHashST() {
        LinearProbingHashST_3_4_10<String, Integer> linearProbingHashST_3_4_10 = new LinearProbingHashST_3_4_10<>(16);
        String[] strings = "S E A R C H X M P L".split(" ");
        for (int i = 0; i < strings.length; i++) {
            linearProbingHashST_3_4_10.put(strings[i], i);
        }
        return linearProbingHashST_3_4_10;
    }
}
