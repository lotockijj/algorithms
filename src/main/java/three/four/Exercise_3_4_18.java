package three.four;

/*
Add a constructor to SeparateChainingHashST that gives the client the ability
to specify the average number of probes to be tolerated for searches. Use array resizing
to keep the average list size less than the specified value, and use the technique described
on page 478 to ensure that the modulus for hash() is prime.
 */

import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

public class Exercise_3_4_18 {

    public static void main(String[] args) {
        SeparateChainingHashST_3_4_18<String, Integer> separateChainingHashST_3_4_18 = fillSeparateChainingHashST();
        Iterable<String> keys = separateChainingHashST_3_4_18.keys();
        StreamSupport.stream(keys.spliterator(), false)
                .filter(Objects::nonNull)
                .forEach(e -> System.out.print(e + ",  "));

        System.out.println();

        List<Integer> values = separateChainingHashST_3_4_18.values();
        values.stream()
                .filter(Objects::nonNull)
                .forEach(e -> System.out.print(e + ",  "));

        System.out.println();

        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) != null){
                System.out.print(i + ", ");
            }
        }

        System.out.println("\n" + "Test get key M: " + separateChainingHashST_3_4_18.get("M"));
    }

    public static SeparateChainingHashST_3_4_18<String, Integer> fillSeparateChainingHashST() {
        SeparateChainingHashST_3_4_18<String, Integer> separateChainingHashST_3_4_18 = new SeparateChainingHashST_3_4_18<>();
        String[] strings = "S E A R C H X M P L".split(" ");
        for (int i = 0; i < strings.length; i++) {
            separateChainingHashST_3_4_18.put(strings[i], i);
        }
        return separateChainingHashST_3_4_18;
    }
}