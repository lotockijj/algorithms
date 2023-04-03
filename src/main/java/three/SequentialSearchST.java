package three;

import java.util.ArrayList;
import java.util.List;

public class SequentialSearchST <Key, Value>{
    public static int countOfCompares = 0;

    private Node first; // first node in the linked list
    private Node cachingNode;
    private class Node { // linked-list node
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) { // Search for key, return associated value.
        if(cachingNode != null && key == cachingNode.key){
            return cachingNode.val;
        }
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.val; // search hit
        return null; // search miss
    }

    public void put(Key key, Value val) { // Search for key. Update value if found; grow table if new.
        if(cachingNode != null && key == cachingNode.key){
            cachingNode.val = val;
            return;
        }
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) {
                countOfCompares++;
                x.val = val;
                return;
            } // Search hit: update val.
        first = new Node(key, val, first); // Search miss: add new node.
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

    public List<Key> keys(){
        List<Key> nodeKeys = new ArrayList<>();
        Node temp = first;
        while (temp != null){
            nodeKeys.add(temp.key);
            temp = temp.next;
        }
        return nodeKeys;
    }

    public boolean delete(Key key){
        boolean result = false;
        Node temp = first;
        Node previousNode = null;
        while (temp != null){
            if(temp.key == key){
                previousNode.next = temp.next;
                result = true;
                break;
            }
            previousNode = temp;
            temp = temp.next;
        }
        return result;
    }

    public boolean contains(Key key){
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                cachingNode = x;
                return true;
            }
        }
        return false;
    }

    public Node getFirst(){
        return first;
    }
}