package three.five;

/*
Multisets. After referring to Exercises 3.5.2 and 3.5.3 and the previous exercise, develop APIs MultiHashSET
and MultiSET for multisets (sets that can have equal keys) and implementations SeparateChainingMultiSET and
BinarySearchMultiSET for multisets and ordered multisets, respectively.
 */

import java.util.List;

public class Exercise_3_5_18 {
    private final static int LEN = 10;

    public static void main(String[] args) {
        MultiHashSET<String, Integer> multiHashSET = new MultiHashSET<>();
        for (int i = 0; i < LEN; i++) {
            multiHashSET.put(i + 1 + "", i + 1);
        }
        multiHashSET.put(1 + "", 100);
        List<String> keys = multiHashSET.getKeys();
        List<Integer> vals = multiHashSET.getVals();
        for (int i = 0; i < keys.size(); i++) {
            if(keys.get(i) != null) {
                //System.out.println(keys.get(i) + " -> " + vals.get(i));
            }
        }
        MultiSET<String> multiSET = new MultiSET<>();
        for (int i = 0; i < LEN; i++) {
            multiSET.put(i + 1 + "");
        }
        multiSET.put(1 + "");
        multiSET.keys().stream().forEach(System.out::println);
    }
}
