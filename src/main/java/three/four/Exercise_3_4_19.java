package three.four;

//Implement keys() for SeparateChainingHashST and LinearProbingHashST.

import java.util.Objects;

public class Exercise_3_4_19 {

    public static void main(String[] args) {
        String[] strings = "S E A R C H X M P L".split(" ");
        LinearProbingHashST<String, Integer> linearProbingHashST = new LinearProbingHashST<>();
        for (int i = 0; i < strings.length; i++) {
            linearProbingHashST.put(strings[i], i);
        }

        linearProbingHashST.getKeys().stream().filter(Objects::nonNull).forEach(e -> System.out.print(e + ", "));

        System.out.println();

        linearProbingHashST.getVals().stream().filter(Objects::nonNull).forEach(e -> System.out.print(e + ", "));
    }
}
