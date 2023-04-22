package three.five;

import java.util.LinkedList;

public class Queue_3_5_28<Item extends Comparable<Item>> {
    private LinkedList<Item> items;
    private BinarySearchSET<Item> everInsertedElements;
    private int initialLength = 1000;

    public Queue_3_5_28() {
        items = new LinkedList<>();
        everInsertedElements = new BinarySearchSET<>(initialLength);
    }

    public boolean add(Item item){
        boolean result = false;
        if(!everInsertedElements.contains(item)){
            items.add(item);
            everInsertedElements.put(item);
            result = true;
        }
        return result;
    }
}
