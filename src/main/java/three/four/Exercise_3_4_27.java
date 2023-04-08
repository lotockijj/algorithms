package three.four;

/*
Double probing. Modify SeparateChainingHashST to use a second hash function and pick the shorter of the two lists.
Give a trace of the process of inserting the keys E A S Y Q U T I O N in that order into an initially empty table
of size M =3 using the function 11 k % M (for the kth letter) as the first hash function and the function
17 k % M (for the kth letter) as the second hash function. Give the average number of
probes for random search hit and search miss in this table.
*/

import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

public class Exercise_3_4_27 {

    public static void main(String[] args) {
        SeparateChainingHashST_3_4_27<String, Integer> separateChainingHashST_3_4_27 = fillSeparateChainingHashST();
        Iterable<String> keys = separateChainingHashST_3_4_27.keys();
        StreamSupport.stream(keys.spliterator(), false)
                .filter(Objects::nonNull)
                .forEach(e -> System.out.print(e + ",  "));

        System.out.println();

        List<Integer> values = separateChainingHashST_3_4_27.values();
        values.stream()
                .filter(Objects::nonNull)
                .forEach(e -> System.out.print(e + ",  "));

        System.out.println();

        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) != null){
                System.out.print(i + ", ");
            }
        }
    }

    public static SeparateChainingHashST_3_4_27<String, Integer> fillSeparateChainingHashST() {
        SeparateChainingHashST_3_4_27<String, Integer> SeparateChainingHashST_3_4_27 = new SeparateChainingHashST_3_4_27<>(3);
        String[] strings = "S E A R C H X M P L".split(" ");
        for (int i = 0; i < strings.length; i++) {
            SeparateChainingHashST_3_4_27.put(strings[i], i);
        }
        return SeparateChainingHashST_3_4_27;
    }
}
