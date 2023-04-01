package three;

/* Modify BinarySearchST to maintain one array of Item objects that contain
   keys and values, rather than two parallel arrays. Add a constructor that takes an array of
   Item values as argument and uses mergesort to sort the array.*/

import java.util.Random;

public class Exercise_3_1_12 {

    public static void main(String[] args) {
        Item<String, Integer>[] items = fillItems(10);
        BinarySearchST_Item binarySearchST_item = new BinarySearchST_Item(items);
        printItems(items);
    }

    private static void printItems(Item<String, Integer>[] items) {
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i].key + " " + items[i].value);
        }
    }

    private static Item<String, Integer>[] fillItems(int n) {
        Item<String, Integer>[] items = new Item[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            items[i] = new Item<>(Integer.toString(random.nextInt(10)), random.nextInt(1000));
        }
        return items;
    }
}
