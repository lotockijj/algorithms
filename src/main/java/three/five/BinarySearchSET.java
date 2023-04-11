package three.five;

import org.apache.commons.lang3.ArrayUtils;

public class BinarySearchSET <Key extends Comparable<Key>> {
    private Key[] keys;
    private int N;

    public BinarySearchSET(int capacity) { // See Algorithm 1.1 for standard array-resizing code.
        keys = (Key[]) new Comparable[capacity];
    }

    public int size() {
        return N;
    }

    public Key get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0){
            return keys[i];
        }
        else return null;
    }

    public int rank(Key key) {
        int lo = 0, hi = N-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public void put(Key key) { // Search for key. Update value if found; grow table if new.
        int i = rank(key);
        for (int j = N; j > i; j--) {
            keys[j] = keys[j-1];
        }
        keys[i] = key;
        N++;
    }

    // See Exercise 3.1.16 for this method.
    public void delete(Key key){
        int rank = rank(key);
        keys = ArrayUtils.removeElement(keys, keys[rank]);
        N--;
    }

    public Key[] getKeys(){
        return keys;
    }

    public Key floor(Key key){
        Key keyResult = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            if(keys[i] != null && key.compareTo(keys[i]) < 0){
                keyResult = keys[i];
            }
        }
        return keyResult;
    }

    public boolean isEmpty(){
        return N == 0;
    }
}