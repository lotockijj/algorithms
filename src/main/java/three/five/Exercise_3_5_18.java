package three.five;

/*
Multisets. After referring to Exercises 3.5.2 and 3.5.3 and the previous exercise, develop APIs MultiHashSET
and MultiSET for multisets (sets that can have equal keys) and implementations SeparateChainingMultiSET and
BinarySearchMultiSET for multisets and ordered multisets, respectively.
 */

import java.util.List;

public class Exercise_3_5_18 {
    private final static int LEN = 10;
    private static final String[] stringsUpperCase = ("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z").split(" ");

    public static void main(String[] args) {

        BinarySearchMultiSET<String> binarySearchMultiSET = new BinarySearchMultiSET<>(LEN*LEN);
        for (int i = 0; i < stringsUpperCase.length; i++) {
            binarySearchMultiSET.put(stringsUpperCase[i]);
        }
        binarySearchMultiSET.put("A");
        Comparable[] binaryKeys = binarySearchMultiSET.getKeys();
        for (int i = 0; i < binaryKeys.length; i++) {
            Comparable binaryKey = binaryKeys[i];
            if(binaryKey != null){
                System.out.print(binaryKey + ", ");
            }
        }

        System.out.println();

        SeparateChainingMultiSET<String> separateChainingMultiSET = new SeparateChainingMultiSET<>();
        for (int i = 0; i < LEN; i++) {
            separateChainingMultiSET.put(i + 1 + "");
        }
        separateChainingMultiSET.put(1 + "");
        separateChainingMultiSET.put(1 + "");
        List<String> keysSP = separateChainingMultiSET.keysAsList();
        List<Integer> valuesSP = separateChainingMultiSET.values();
        for (int i = 0; i < keysSP.size(); i++) {
            System.out.println(keysSP.get(i) + " - " + valuesSP.get(i));
        }

        MultiHashSET<String, Integer> multiHashSET = new MultiHashSET<>();
        for (int i = 0; i < LEN; i++) {
            multiHashSET.put(i + 1 + "", i + 1);
        }
        multiHashSET.put(1 + "", 100);
        List<String> keys = multiHashSET.getKeys();
        List<Integer> vals = multiHashSET.getVals();
        for (int i = 0; i < keys.size(); i++) {
            if(keys.get(i) != null) {
                System.out.println(keys.get(i) + " -> " + vals.get(i));
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
