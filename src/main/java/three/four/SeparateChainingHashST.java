package three.four;

import three.SequentialSearchST;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SeparateChainingHashST<Key, Value> {
    private int N; // number of key-value pairs
    private int M; // hash table size
    private SequentialSearchST<Key, Value>[] st; // array of ST objects

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) { // Create M linked lists.
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST();
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }

    public Iterable<Key> keys(){
        return Arrays.asList(st).stream()
                .map(SequentialSearchST::keys)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
//  See Exercise 3.4.19.
}