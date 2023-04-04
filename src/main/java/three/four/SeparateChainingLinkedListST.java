package three.four;

import org.apache.jena.atlas.lib.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SeparateChainingLinkedListST<Key, Value> {

    private int N; // number of key-value pairs
    private int M; // hash table size
    private LinkedList<Pair<Key, Value>>[] st; // array of ST objects

    public SeparateChainingLinkedListST() {
        this(997);
    }

    public SeparateChainingLinkedListST(int m) { // Create M linked lists.
        M = 997;
        st = new LinkedList[m];
    }

    private int hash(Pair pair) {
        return (pair.car().hashCode() & 0x7fffffff) % M;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        if(st[hash(key)] == null) return null;
        Optional<Pair<Key, Value>> pair = st[hash(key)].stream().filter(e -> e.car().equals(key)).findAny();
        return pair.get().cdr();
    }

    public void put(Key key, Value val) {
        Pair<Key, Value> pair = new Pair<>(key, val);
        if(st[hash(key)] == null){
            st[hash(key)] = new LinkedList<>();
            st[hash(key)].add(pair);
        } else {
            if(doesntContainKey(st[hash(key)], key)){
                st[hash(key)].removeIf(e -> e.car().equals(key));
                st[hash(key)].add(pair);
            }
        }
    }

    private boolean doesntContainKey(LinkedList<Pair<Key, Value>> pairs, Key key) {
        Optional<Pair<Key, Value>> pair = pairs.stream().filter(e -> e.car() != key).findAny();
        return pair.isPresent() && pair.get().car().equals(key);
    }

    public Iterable<Key> keys(){
        return Arrays.asList(st).stream()
                .filter(e -> e != null && e.size() != 0)
                .flatMap(List::stream)
                .map(Pair::car)
                .collect(Collectors.toList());
    }

    public void removeIfTheAraMoreDuplicates(int thresholdOfDuplicates){
        for (int i = 0; i < st.length; i++) {
            if(st[i] != null) {
                st[i].removeIf(e -> (Integer) e.cdr() >= thresholdOfDuplicates);
            }
        }
    }

}
