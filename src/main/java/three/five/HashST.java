package three.five;

public class HashST {
    private int N; // number of key-value pairs in the table
    private int M = 16; // size of linear-probing table
    private int[] keys; // the keys
    private double[] vals; // the values

    private double averageCostOfSearchHit;

    public HashST() {
        keys = new int[M];
        vals = new double[M];
    }

    public HashST(int M) {
        keys = new int[M];
        vals = new double[M];
    }

    private int hash(int key) {
        return (key & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        HashST t = new HashST(cap);
        for (int i = 0; i < M; i++)
            if (keys[i] != 0)
                t.put(keys[i], vals[i]);
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    public void put(int key, double val) {
        if (N >= M/2) resize(2*M); // double M (see text)
        int i;
        for (i = hash(key); keys[i] != 0; i = (i + 1) % M)
            if (keys[i] == key) {
                vals[i] = val; return;
            }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public double get(int key) {
        int countOfMiss = 0;
        averageCostOfSearchHit = 1.0;
        for (int i = hash(key); keys[i] != 0; i = (i + 1) % M) {
            countOfMiss++;
            if (keys[i] == key) {
                averageCostOfSearchHit = countOfMiss > 0 ? averageCostOfSearchHit/countOfMiss : 0.0;
                return vals[i];
            }
        }
        return 0;
    }

    public void delete(int key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (!(key == keys[i]))
            i = (i + 1) % M;
        keys[i] = 0;
        vals[i] = 0;
        i = (i + 1) % M;
        while (keys[i] != 0) {
            int keyToRedo = keys[i];
            double valToRedo = vals[i];
            keys[i] = 0;
            vals[i] = 0;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M/8) resize(M/2);
    }

    public boolean contains(int key) {
        return get(key) != 0;
    }

    public int[] getKeys() {
        return keys;
    }

    public double[] getVals() {
        return vals;
    }

    public int size(){
        return N;
    }

    public double getAverageCostOfSearchHit() {
        return averageCostOfSearchHit;
    }

    public double getAverageCostOfSearchSearchMiss() {
        return 1/averageCostOfSearchHit;
    }
}
