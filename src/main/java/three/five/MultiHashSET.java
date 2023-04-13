package three.five;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MultiHashSET<Key, Value> {
    private int N; // number of key-value pairs in the table
    private int M = 32; // size of linear-probing table
    private Key[] keys; // the keys
    private Value[] vals; // the values

    private double averageCostOfSearchHit;

    public MultiHashSET() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    public MultiHashSET(int M) {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        int hash = (key.hashCode() & 0x7fffffff) % M;
        if(hash >= keys.length) hash = (key.hashCode() & 0x7fffffff) % (M/2);
        return hash;
    }

    private void resize(int cap) {
        MultiHashSET<Key, Value> t = new MultiHashSET<>(cap);
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
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if(contains(keys[i])) continue;
            vals[i] = val;
            break;
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
        while (i < keys.length && keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
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

    public MultiHashSET<Key, Value> createMultiHashSET(Key[] universeKey, Value[] universeValue){
        MultiHashSET<Key, Value> multiHashSET = new MultiHashSET<Key, Value>();
        for (int i = 0; i < universeKey.length; i++) {
            multiHashSET.put(universeKey[i], universeValue[i]);
        }
        return multiHashSET;
    }

    public List<Key> getKeys() {
        return Arrays.stream(keys).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public List<Value> getVals() {
        return Arrays.stream(vals).filter(Objects::nonNull).collect(Collectors.toList());
    }
    
    public void complement(Key[] outerKeys, Value[] outerValues){ //set of keys in the universe that are not in this set
        for (int i = 0; i < outerKeys.length; i++) {
            if(!contains(outerKeys[i])){
                put(outerKeys[i], outerValues[i]);
            }
        }
    }

    public void union(MultiHashSET<Key, Value> a) { //put any keys from a into the set that are not already there
        List<Key> keys = a.getKeys();
        List<Value> vals = a.getVals();
        for (int i = 0; i < keys.size(); i++) {
            if(!contains(keys.get(i))){
                put(keys.get(i), vals.get(i));
            }
        }
    }

    public void intersection(MultiHashSET<Key, Value> a) { //remove any keys from this set that are not in a
        List<Key> keys = a.getKeys();
        for (int i = 0; i < keys.size(); i++) {
            delete(keys.get(i));
        }
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return getKeys().size() == 0;
    }
}