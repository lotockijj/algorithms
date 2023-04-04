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
        if(st[hash(key)] == null){
            st[hash(key)] = new LinkedList<>();
        }
        st[hash(key)].add(new Pair(key, val));
    }

    public Iterable<Key> keys(){
        return Arrays.asList(st).stream()
                .flatMap(List::stream)
                .map(Pair::car)
                .collect(Collectors.toList());
    }
//  See Exercise 3.4.19.
}
