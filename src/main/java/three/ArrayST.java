package three;

public class ArrayST <Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int N = 0;

    public ArrayST(int capacity){
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
    }

    public void put(Key key, Value value){
        if(N < keys.length){
            keys[N] = key;
            values[N] = value;
            N++;
        }
    }

    public Value getValue(Key key){
        for (int i = 0; i < keys.length; i++) {
            if(keys[i] == key){
                Value value = values[i];
                rearrangeKeysValues(key, value, i);
                return value;
            }
        }
        return null;
    }

    private void rearrangeKeysValues(Key key, Value value, int i) {
        for (int j = i; j > 0; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[0] = key;
        values[0] = value;
    }

    public Key[] getKeys() {
        return keys;
    }

    public void setKeys(Key[] keys) {
        this.keys = keys;
    }

    public Value[] getValues() {
        return values;
    }

    public void setValues(Value[] values) {
        this.values = values;
    }
}
