package three.four;

import java.util.Arrays;
import java.util.List;

public class LinearProbingHashST_3_4_26<Key, Value> {
    private int N; // number of key-value pairs in the table
    private int M = 32; // size of linear-probing table
    private Key[] keys; // the keys
    private Value[] vals; // the values

    private double averageCostOfSearchHit;

    public LinearProbingHashST_3_4_26() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    public LinearProbingHashST_3_4_26(int M) {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        LinearProbingHashST_3_4_26<Key, Value> t;
        t = new LinearProbingHashST_3_4_26<Key, Value>(cap);
        for (int i = 0; i < M; i++)
            if (keys[i] != null)
                t.put(keys[i], vals[i]);
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    public void put(Key key, Value val) {
        if (N >= M/2) resize(2*M); // double M (see text)
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) {
                vals[i] = val; return;
            }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        int countOfMiss = 0;
        averageCostOfSearchHit = 1.0;
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            countOfMiss++;
            if (keys[i].equals(key)) {
                averageCostOfSearchHit = countOfMiss > 0 ? averageCostOfSearchHit/countOfMiss : 0.0;
                return vals[i];
            }
        }
        return null;
    }

    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % M;
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
//        while (keys[i] != null) {
//            Key keyToRedo = keys[i];
//            Value valToRedo = vals[i];
//            keys[i] = null;
//            vals[i] = null;
//            N--;
//            put(keyToRedo, valToRedo);
//            i = (i + 1) % M;
//        }
        N--;
        if (N > 0 && N == M/8) resize(M/2);
    }

    private boolean contains(Key key) {
        return get(key) != null;
    }

    public List<Key> getKeys() {
        return Arrays.asList(keys);
    }

    public List<Value> getVals() {
        return Arrays.asList(vals);
    }


}