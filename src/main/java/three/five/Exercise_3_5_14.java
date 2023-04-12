package three.five;

/*
Develop and test a static method invert() that takes as argument an ST<String, Bag<String>> and
produces as return value the inverse of the given symbol table (a symbol table of the same type).
 */

import edu.princeton.cs.algs4.Bag;
import three.three.BST;

public class Exercise_3_5_14 {

    public static void main(String[] args) {
        BST<String, Bag<String>> stringBagST = new BST();
        for (int i = 0; i < 10; i++) {
            String str = i + 1 + "";
            Bag<String> bag = new Bag<>();
            bag.add(str);
            stringBagST.put(str, bag);
        }

        stringBagST.keys().forEach(System.out::println);
    }
}
