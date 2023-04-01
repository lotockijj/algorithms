package three;

import two.Merge;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BinarySearchST_Item<Key extends Comparable<Key>, Value> {
    public static int countOfCompares = 0;
    private Item[] items;

    public BinarySearchST_Item(Item[] items) { // See Algorithm 1.1 for standard array-resizing code.
        this.items = items;
        Merge.sort(items);
    }

    public int size() {
        return items.length;
    }

    public Value get(Key key) {
        Item item = Arrays.asList(items).stream().filter(e -> e.key == key).collect(Collectors.toList()).get(0);
        Value value = item == null ? null : (Value) item.value;
        return value;
    }

    // See Exercise 3.1.16 for this method.
    public void delete(Key key){

    }

    public Object[] getKeys(){
        Object[] objects = Arrays.asList(items).stream().map(e -> e.key).collect(Collectors.toList()).toArray();
        return objects;
    }

    public boolean isEmpty(){
        return false;
    }
}
