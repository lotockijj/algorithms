package three.five;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Iterator;

// TODO All edge cases not counted (decrease of size, deleted all items, mix of methods, delete not existing item etc...)
public class List_3_5_27<Item> implements Iterable<Item>  {
    private Item[] arr;
    private int count;
    private int initialLength = 4;

    public List_3_5_27() {
        arr = (Item[]) new Object[initialLength];
    }

    public void addFront(Item item) { //add item to the front
        Item temp = arr[0];
        arr[0] = item;
        if(initialLength < count + 2){
            resiseArray();
        }
        for (int i = 1; i < arr.length - 1; i++) {
            Item temp2 = arr[i];
            arr[i] = temp;
            temp = temp2;
        }
        count++;
    }

    public void addBack(Item item) { //add item to the back
        if(initialLength < count + 2){
            resiseArray();
        }
        arr[count] = item;
        count++;
    }

    public Item deleteFront() { //remove from the front
        Item deletedItem = arr[0];
        arr[0] = null;
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        count--;
        return deletedItem;
    }

    public Item deleteBack() {//remove from the back
        Item deletedItem = arr[count - 1];
        arr[count] = null;
        count--;
        return deletedItem;
    }

    public void deleteByItem(Item item) { //remove item from the list
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == item || arr[i] == null){
                arr[i] = arr[i + 1];
                arr[i + 1] = null;
                count--;
            }
        }
    }

    public void add(int index, Item item) { //add item as the ith in the list
        if(initialLength < count + 2){
            resiseArray();
        }
        Item tempItem = arr[index];
        arr[index] = item;
        for (int i = index; i < arr.length - 1; i++) {
            Item tempInnerItem = arr[i + 1];
            arr[i + 1] = tempItem;
            tempItem = tempInnerItem;
        }
        count++;
    }

    public Item deleteByIndex(int index) { //remove the ith item from the list
        Item deletedItem = arr[index];
        arr[index] = null;
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
            count--;
        }
        return deletedItem;
    }

    public boolean contains(Item item) { //is key in the list?
        boolean contains = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == item){
                contains = true;
            }
        }
        return contains; //ArrayUtils.contains(arr, item);
    }

    public boolean isEmpty() { //is the list empty?
        return count == 0;
    }

    public int size() { //number of items in the list
        return count;
    }

    @Override
    public Iterator<Item> iterator() {
        return Arrays.stream(arr).iterator();
    }

    private void resiseArray() {
        initialLength *= 2;
        Item[] newArr = (Item[]) new Object[initialLength];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public Item[] getArr() {
        return arr;
    }

    public int getCount() {
        return count;
    }

    public int getInitialLength() {
        return initialLength;
    }
}
