package three.five;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MathSET<Key> {
    private MultiSET<Key> multiSET;

    public MathSET(Key[] universe) { //create a set
        multiSET = new MultiSET<>();
        for (int i = 0; i < universe.length; i++) {
            multiSET.put(universe[i]);
        }
    }

    public void add(Key key) { //put key into the set
        multiSET.put(key);
    }

    public MathSET<Key> complement(Set<Key> set){ //set of keys in the universe that are not in this set
        MathSET<Key> mathSET = new MathSET<Key>((Key[]) multiSET.keys().toArray());
        for(Key k : set){
            mathSET.add(k);
        }
        return mathSET;
    }

    public void union(MathSET<Key> a) { //put any keys from a into the set that are not already there
        for(Key key : a.multiSET.keys()){
            multiSET.put(key);
        }
    }

    public void intersection(MathSET<Key> a) { //remove any keys from this set that are not in a
        List<Key> aKeys = a.multiSET.keys();
        List<Key> thisKeys = this.multiSET.keys();
        for (Key key : thisKeys) {
            if (!aKeys.contains(key)) {
                multiSET.delete(key);
            }
        }
    }

    public void delete(Key key){ //remove key from the set
        multiSET.delete(key);
    }

    public boolean contains(Key key){ //is key in the set?
        return multiSET.contains(key);
    }

    public boolean isEmpty() { //is the set empty?
        return multiSET.size() == 0;
    }

    public int size() { //number of keys in the set
        return multiSET.size();
    }
}
