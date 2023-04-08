package three.four;

/*
Lazy delete for linear probing. Add to LinearProbingHashST a delete() method that deletes a key-value pair
by setting the value to null (but not removing the key) and later removing the pair from the table in resize().
Your primary challenge is to decide when to call resize(). Note : You should overwrite the null value if
a subsequent put() operation associates a new value with the key. Make sure that your program takes into account
the number of such tombstone items, as well as the number of empty positions, in making the decision whether to expand
or contract the table.
 */

import java.util.List;
import java.util.Objects;

public class Exercise_3_4_26 {

    public static void main(String[] args) {
        LinearProbingHashST_3_4_26<String, Integer> linearProbingHashST_3_4_26 = fillSeparateChainingHashST();
        List<String> keys = linearProbingHashST_3_4_26.getKeys();
        linearProbingHashST_3_4_26.delete("S");
        linearProbingHashST_3_4_26.delete("A");
        linearProbingHashST_3_4_26.delete("Z");
        keys.stream().filter(Objects::nonNull).forEach(e -> System.out.print(e + ",  "));
    }

    public static LinearProbingHashST_3_4_26<String, Integer> fillSeparateChainingHashST() {
        LinearProbingHashST_3_4_26<String, Integer> linearProbingHashST_3_4_10 = new LinearProbingHashST_3_4_26<>(64);
        String[] strings = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
        for (int i = 0; i < strings.length; i++) {
            linearProbingHashST_3_4_10.put(strings[i], i);
        }
        return linearProbingHashST_3_4_10;
    }
}

