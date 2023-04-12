package three.five;

/*
Modify BST to keep duplicate keys in the tree. Return any value associated with the given key for get(),
and remove all nodes in the tree that have keys equal to the given key for delete().
 */

import java.util.List;

public class Exercise_3_5_9 {

    public static void main(String[] args) {
        BST_3_5_9<Integer, Integer> bst_3_5_9 = new BST_3_5_9();
        for (int i = 0; i < 10; i++) {
            bst_3_5_9.put(i + 1, i + 1);
        }
        bst_3_5_9.put(1, 100);
        List list = bst_3_5_9.get(1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        bst_3_5_9.delete(1);
        list = bst_3_5_9.get(1);
        for (int i = 0; list != null && i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("Min value: " + bst_3_5_9.min()
                + " . Max value: " + bst_3_5_9.max()
                + " . Floor of 7: " +  bst_3_5_9.floor(7));
    }
}
