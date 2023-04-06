package three.four;

/*
Show the result of using the delete() method on page 471 to delete C from the
table resulting from using LinearProbingHashST with our standard indexing client
(shown on page 469).
 */

import java.util.Arrays;
import java.util.Objects;

public class Exercise_3_4_17 {

    public static void main(String[] args) {
        LinearProbingHashST_3_4_10<String, Integer> linearProbingHashST_3_4_11 = fillSeparateChainingHashST(7);
        Object[] keys= linearProbingHashST_3_4_11.getKeys();
        linearProbingHashST_3_4_11.delete("C");
        Arrays.stream(keys).filter(Objects::nonNull).forEach(e -> System.out.print(e + ",  "));

        System.out.println();

        Object[] values = linearProbingHashST_3_4_11.getVals();
        Arrays.stream(values)
                .filter(Objects::nonNull)
                .map(e -> e.toString())//((Integer) values[1]).value
                .forEach(e -> System.out.print(e + ",  "));

        System.out.println();

        for (int i = 0; i < values.length; i++) {
            if (values[i] != null){
                System.out.print(i + ", ");
            }
        }
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
