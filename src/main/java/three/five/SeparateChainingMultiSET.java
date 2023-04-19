package three.five;

import three.SequentialSearchST;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SeparateChainingMultiSET <Key> {
    private int N; // number of key-value pairs
    private int M; // hash table size
    private SequentialSearchST<Key, Integer>[] st; // array of ST objects

    public SeparateChainingMultiSET() {
        this(997);
    }

    public SeparateChainingMultiSET(int M) { // Create M linked lists.
        this.M = M;
        st = (SequentialSearchST<Key, Integer>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST();
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Integer get(Key key) {
        return (Integer) st[hash(key)].get(key);
    }

    public void put(Key key) {
        int value = contains(key) ? st[hash(key)].get(key) + 1 : 1;
        st[hash(key)].put(key, value);
    }

    public Iterable<Key> keys(){
        return Arrays.asList(st).stream()
                .map(SequentialSearchST::keys)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<Key> keysAsList(){
        return Arrays.asList(st).stream()
                .map(SequentialSearchST::keys)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<Integer> values(){
        return Arrays.asList(st).stream()
                .map(SequentialSearchST::values)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public int getSize(){
        return st.length;
    }

    public void delete(Key key) {
        st[hash(key)].delete(key);
    }

    public SequentialSearchST<Key, Integer>[] getSt() {
        return st;
    }

    public boolean contains(Key key){
        return st[hash(key)].contains(key);
    }

    //  See Exercise 3.4.19.
}