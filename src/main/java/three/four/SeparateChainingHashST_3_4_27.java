package three.four;

import three.SequentialSearchST;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SeparateChainingHashST_3_4_27<Key, Value> {
    private int N; // number of key-value pairs
    private int M; // hash table size
    private SequentialSearchST<Key, Value>[] st; // array of ST objects

    public SeparateChainingHashST_3_4_27() {
        this(997);
    }

    public SeparateChainingHashST_3_4_27(int M) { // Create M linked lists.
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST();
    }

    private int hash11(Key key) {
        System.out.println("hash11");
        return 11*(key.hashCode()) % M;
    }

    private int hash17(Key key) {
        System.out.println("hash17");
        return 17*(key.hashCode()) % M;
    }

    public Value get(Key key) {
        Value value = null;
        if(st[hash11(key)] != null){
            value = st[hash11(key)].get(key);
        } else {
            value = st[hash17(key)].get(key);
        }
        return value;
    }

    public void put(Key key, Value val) {
        if(st[hash11(key)].size() <= st[hash17(key)].size()){
            st[hash11(key)].put(key, val);
        } else {
            st[hash17(key)].put(key, val);
        }
    }

    public Iterable<Key> keys(){
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
        if(st[hash11(key)] != null){
            st[hash11(key)].delete(key);
        } else {
            st[hash17(key)].delete(key);
        }
    }
}
