package three;

import org.apache.commons.lang3.ArrayUtils;

public class BinarySearchST <Key extends Comparable<Key>, Value> {
    public static int countOfCompares = 0;
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) { // See Algorithm 1.1 for standard array-resizing code.
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }

    public int rank(Key key) {
        int lo = 0, hi = N-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            countOfCompares++;
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public void put(Key key, Value val) { // Search for key. Update value if found; grow table if new.
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val; return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key; vals[i] = val;
        N++;
    }

    // See Exercise 3.1.16 for this method.
    public void delete(Key key){
        int rank = rank(key);
        keys = ArrayUtils.removeElement(keys, keys[rank]);
        vals = ArrayUtils.removeElement(vals, vals[rank]);
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
        return false;
    }
}