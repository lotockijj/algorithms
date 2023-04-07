package three.four;

import three.SequentialSearchST;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SeparateChainingHashST_3_4_18<Key, Value> {
    private int N; // number of key-value pairs
    private int M; // hash table size
    private SequentialSearchST<Key, Value>[] st; // array of ST objects
    private int[] primes = {31, 61, 127, 251, 509, 1021, 2039, 4093, 8191, 16381, 32749, 65521, 131071, 262139,
            524287, 1048573, 2097143, 4194301, 8388593, 16777213, 33554393, 67108859, 134217689, 268435399,
            536870909, 1073741789, 2147483647};

    public SeparateChainingHashST_3_4_18() {
        this(997);
    }

    public SeparateChainingHashST_3_4_18(int M) { // Create M linked lists.
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST();
    }

    private int hash(Key x){
        int t = x.hashCode() & 0x7fffffff;
        if (Math.log(M) < 26) t = t % primes[(int) Math.round(Math.log(M)) + 5];
        return t % M;
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

}