package three.four;

import java.util.Arrays;
import java.util.Objects;

public class Exercise_3_4_12 {

    public static void main(String[] args) {
        LinearProbingHashST_3_4_10<String, Integer> linearProbingHashST_3_4_11 = fillSeparateChainingHashST(7);
        Object[] keys= linearProbingHashST_3_4_11.getKeys();
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
        String[] strings = "A B C D E F G".split(" ");
        for (int i = 0; i < strings.length; i++) {
            linearProbingHashST_3_4_10.put(strings[i], i);
        }
        return linearProbingHashST_3_4_10;
    }
}
