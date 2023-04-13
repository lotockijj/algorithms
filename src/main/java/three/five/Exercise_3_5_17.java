package three.five;

/*
Mathematical sets. Your goal is to develop an implementation of the following
API MathSET for processing (mutable) mathematical sets:
    public class MathSET<Key>
        MathSET(Key[] universe) //create a set
        void add(Key key) //put key into the set
        MathSET<Key> complement() //set of keys in the universe that are not in this set
        void union(MathSET<Key> a) //put any keys from a into the set that are not already there
        void intersection(MathSET<Key> a) //remove any keys from this set that are not in a
        void delete(Key key) //remove key from the set
        boolean contains(Key key) //is key in the set?
        boolean isEmpty() //is the set empty?
        int size() //number of keys in the set

Use a symbol table . Extra credit : Represent sets with arrays of boolean values.
 */

public class Exercise_3_5_17 {
}
