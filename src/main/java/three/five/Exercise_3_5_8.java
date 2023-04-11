package three.five;

/*
Modify LinearProbingHashST to keep duplicate keys in the table. Return any value associated with the given
key for get(), and remove all items in the table that have keys equal to the given key for delete().
 */

public class Exercise_3_5_8 {

    public static void main(String[] args) {
        LinearProbingHashST_3_5_8 linearProbingHashST_3_5_8 = new LinearProbingHashST_3_5_8();
        for (int i = 0; i < 10; i++) {
            linearProbingHashST_3_5_8.put(i + 1, i + 10);
        }
        linearProbingHashST_3_5_8.put(1, 1);
        System.out.println(linearProbingHashST_3_5_8.getKeys());
    }
}
