package three.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LinearProbingHashST_3_5_8 <Key, Value> {
    private int N; // number of key-value pairs in the table
    private int M = 16; // size of linear-probing table
    private Key[] keys; // the keys
    private List<Value>[] vals; // the values

    public LinearProbingHashST_3_5_8() {
        keys = (Key[]) new Object[M];
        vals = new ArrayList[M];
    }

    public LinearProbingHashST_3_5_8(int M) {
        this.M = M;
        keys = (Key[]) new Object[M];
        vals = new ArrayList[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        LinearProbingHashST_3_5_8<Key, Value> t;
        t = new LinearProbingHashST_3_5_8<>(cap);
        for (int i = 0; i < cap; i++)
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
                vals[i].add(val);
                return;
            }
        keys[i] = key;
        vals[i] = Arrays.asList(val)
                .stream()
                .collect(Collectors.toList());
        N++;
    }

    public void put(Key key, List<Value> values) {
        if (N >= M/2) resize(2*M); // double M (see text)
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) {
                vals[i].addAll(values);
                return;
            }
        keys[i] = key;
        vals[i] = values;
        N++;
    }

    public List<Value> get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
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
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            List<Value> valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M/8) resize(M/2);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public List<Key> getKeys() {
        return Arrays.stream(keys)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public List<Value> getVals() {
        return Arrays.stream(vals)
                .filter(Objects::nonNull)
                .map(e -> e.stream().collect(Collectors.toList()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public int size(){
        return N;
    }
}