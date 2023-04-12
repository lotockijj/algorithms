package three.five;

/*
Modify RedBlackBST to keep duplicate keys in the tree. Return any value associated with the given key for get(),
and remove all nodes in the tree that h ave keys equal to the given key for delete().
 */

public class Exercise_3_5_10 {

    public static void main(String[] args) {
        RedBlackBST_3_5_10<Integer, Integer> redBlackBST_3_5_10 = new RedBlackBST_3_5_10<>();
        for (int i = 0; i < 10; i++) {
            redBlackBST_3_5_10.put(i + 1, i + 1);
        }
        redBlackBST_3_5_10.put(4, 40);
    }
}
