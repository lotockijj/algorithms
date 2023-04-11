package three.five;

import java.util.ArrayList;
import java.util.List;

public class SequentialSearchSET  <Key>{
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
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) {
                return;
            } // Search hit: update val.
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
                return true;
            }
        }
        return false;
    }

    public Node getFirst(){
        return first;
    }
}