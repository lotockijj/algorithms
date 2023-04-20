package three.five;

/*
Equal keys in symbol tables. Consider the API MultiST (unordered or ordered) to be the same as our
symbol-table APIs  defined on page 363 and page 366, but with equal keys allowed, so that
the semantics of get() is to return any value associated with the given key, and we add a new method
    Iterable<Value> getAll(Key key)
that returns all values associated with the given key. Using our code for SeparateChainingST and BinarySearchST
as a starting point, develop implementations SeparateChainingMultiST and BinarySearchMultiST for these APIs.
 */

import static three.five.Exercise_3_5_18.LEN;

public class Exercise_3_5_19 {

    public static void main(String[] args) {
        MultiSET<String> multiSET = new MultiSET<>();
        for (int i = 0; i < LEN; i++) {
            multiSET.put(i + 1 + "");
        }
        multiSET.put("2");
        System.out.println(multiSET.get("3"));
    }
}
