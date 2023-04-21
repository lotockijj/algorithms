package three.five;

/*
LRU cache. Create a data structure that supports the following operations: access and remove.
The access operation inserts the item onto the data structure if it’s not already present.
The remove operation deletes and returns the item that was least recently accessed.
Hint : Maintain the items in order of access in a doubly linked list, along with pointers to the first
and last nodes. Use a symbol table with keys = items, values = location in linked list.
When you access an element, delete it from the linked list and reinsert it at the beginning.
When you remove an element, delete it from the end and remove it from the symbol table.
 */

import java.util.LinkedList;

public class Exercise_3_5_26<Key> {
    private LinkedList<Key> list;

    public Exercise_3_5_26() {
        list = new LinkedList<>();
    }

    public void access(Key key){
        if(!list.contains(key)) {
            list.addFirst(key);
        } else {
            list.remove(key);
            list.addFirst(key);
        }
    }

    public Key remove(){
        return list.poll();
    }
}
