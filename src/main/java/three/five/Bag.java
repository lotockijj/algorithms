package three.five;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of bag
    private int n;               // number of elements in bag

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Bag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    // TODO Write jUnit ; removes only one value if there are duplicates
    public void delete(Item item){
        Node<Item> tempItem = first;
        while(tempItem != null) {
            if(first.item == item){
                first = tempItem.next;
                break;
            }
            if(tempItem.next.item == item){
                tempItem.next = tempItem.next.next;
                break;
            }
            tempItem = tempItem.next;
        }
    }

    public Iterator<Item> iterator()  {
        return new LinkedIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    @Override
    public String toString() {
        return first.item.toString();
    }

    public boolean contains(Bag<Item> item){
        boolean result = false;
        Iterator<Item> iterator = iterator();
        while (iterator.hasNext()){
            if(item == iterator.next()){
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean contains(Item item){
        boolean result = false;
        Iterator<Item> iterator = iterator();
        while (iterator.hasNext()){
            if(item == iterator.next()){
                result = true;
                break;
            }
        }
        return result;
    }
}