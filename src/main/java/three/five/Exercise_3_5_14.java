package three.five;

/*
Develop and test a static method invert() that takes as argument an ST<String, Bag<String>> and
produces as return value the inverse of the given symbol table (a symbol table of the same type).
 */

import three.three.BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class Exercise_3_5_14 {

    public static void main(String[] args) {
        BST<String, Bag<String>> stringBagST = new BST();
        BST<String, Bag<String>> inverseStringBagST = new BST();
        for (int i = 0; i < 10; i++) {
            String strValue = i + "A";
            String strKey = (i + 1) * i + "";
            Bag<String> bag = new Bag<>();
            bag.add(strValue);
            stringBagST.put(strKey, bag);
        }
        stringBagST.keys().forEach(e -> changeValues(stringBagST, inverseStringBagST, e));
        stringBagST.keys().forEach(System.out::print);
        System.out.print(" - ");
        stringBagST.values().forEach(System.out::print);
        System.out.println();
        inverseStringBagST.keys().forEach(System.out::print);
        System.out.print(" - ");
        inverseStringBagST.values().forEach(System.out::print);
    }

    private static void changeValues(BST<String, Bag<String>> stringBagST, BST<String, Bag<String>> inverseStringBagST, String e) {
        Bag<String> bag = stringBagST.get(e);
        Bag<String> changedValue = new Bag<>();
        changedValue.add(e);
        e = getNext(bag.spliterator());
        inverseStringBagST.put(e, changedValue);
    }

    public static <String> String getNext(Spliterator<String> spliterator) {
        List<String> result = new ArrayList<>(1);
        if (spliterator.tryAdvance(result::add)) {
            return result.get(0);
        } else {
            return null;
        }
    }
}
