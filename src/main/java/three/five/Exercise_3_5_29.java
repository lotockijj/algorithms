package three.five;

/*
Symbol table with random access. Create a data type that supports inserting a key-value pair, searching for a key
and returning the associated value, and deleting and returning a random key. Hint : Combine a symbol table and a randomized queue.
 */

public class Exercise_3_5_29<Key, Value> {
    private RandomizedQueue<Key> randomizedQueue;
    private MultiHashSET<Key, Value> multiHashSET;

    public Exercise_3_5_29(){
        randomizedQueue = new RandomizedQueue<>();
        multiHashSET = new MultiHashSET<>();
    }

    public void insert(Key key, Value value){
        multiHashSET.put(key, value);
        randomizedQueue.enqueue(key);
    }

    public Value getValueForKey(Key key){
        return multiHashSET.get(key);
    }

    public Key getRandomKey(){
        return randomizedQueue.dequeue();
    }

    public Key deleteRandomKey(){
        Key dequeue = randomizedQueue.dequeue();
        randomizedQueue.enqueue(dequeue);
        multiHashSET.delete(dequeue);
        return dequeue;
    }

}
