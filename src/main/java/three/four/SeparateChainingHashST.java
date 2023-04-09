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

    public List<Key> keysAsList(){
        return Arrays.asList(st).stream()
                .map(SequentialSearchST::keys)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<Value> values(){
        return Arrays.asList(st).stream()
                .map(SequentialSearchST::values)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public int getSize(){
        return st.length;
    }

    public int getEmptyLists(){
        int countOfEmptyLists = 0;
        for (int i = 0; i < st.length; i++) {
            if(st[i].size() == 0){
                countOfEmptyLists++;
            }
        }
        return countOfEmptyLists;
    }

    public void delete(Key key) {
        st[hash(key)].delete(key);
    }

    public SequentialSearchST<Key, Value>[] getSt() {
        return st;
    }

    //  See Exercise 3.4.19.
}