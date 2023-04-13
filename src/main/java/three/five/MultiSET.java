package three.five;

import java.util.ArrayList;
import java.util.List;

public class MultiSET <Key> {
    private Node first; // first node in the linked list

    private class Node { // linked-list node
        Key key;
        Node next;

        public Node(Key key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    public Key get(Key key) { // Search for key, return associated value.
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return key; // search hit
        return null; // search miss
    }

    public void put(Key key) { // Search for key. Update value if found; grow table if new.
        first = new Node(key, first); // Search miss: add new node.
    }

    public int size(){
        int count = 0;
        Node temp = first;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    public List<Key> keys() {
        List<Key> nodeKeys = new ArrayList<>();
        Node temp = first;
        while (temp != null) {
            nodeKeys.add(temp.key);
            temp = temp.next;
        }
        return nodeKeys;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public boolean contains(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return true;
            }
        }
        return false;
    }

    public Node getFirst() {
        return first;

    }

    public Key getFirstKey() {
        return first.key;
    }

    public MultiSET<Key> universe(Key[] universe) {
        MultiSET<Key> multiSET = new MultiSET<>();
        for (int i = 0; i < universe.length; i++) {
            multiSET.put(universe[i]);
        }
        return multiSET;
    }

    public MultiSET<Key> complement(Key[] complement) { //set of keys in the universe that are not in this set
        MultiSET<Key> multiSET = new MultiSET<>();
        for (int i = 0; i < complement.length; i++) {
            Key key = complement[i];
            if (!contains(key)) {
                multiSET.put(key);
            }
        }
        return multiSET;
    }

    public void union(MultiSET<Key> a) { //put any keys from a into the set that are not already there
        List<Key> keys = a.keys();
        for (int i = 0; i < keys.size(); i++) {
            Key key = keys.get(i);
            if (!contains(key)) {
                put(key);
            }
        }
    }

    public void intersection(MultiSET<Key> a) { //remove any keys from this set that are not in a
        List<Key> keys = keys();
        for (int i = 0; i < keys.size(); i++) {
            Key key = keys.get(i);
            if(!a.contains(key)){
                delete(key);
            }
        }
    }

    public boolean isEmpty(){
        return size() == 0;
    }
}