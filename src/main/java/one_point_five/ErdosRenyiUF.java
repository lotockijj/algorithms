package one_point_five;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*Random connections. Develop a UF client ErdosRenyi that takes an integer
value N from the command line, generates random pairs of integers between 0 and N-1,
calling connected() to determine if they are connected and then union() if not (as in
our development client), looping until all sites are connected, and printing the number
of connections generated. Package your program as a static method count() that takes
N as argument and returns the number of connections and a main() that takes N from
the command line, calls count(), and prints the returned value.*/

public class ErdosRenyiUF {
    private int[] id; // access to component id (site indexed)
    private int[] sz; // size of component for roots (site indexed)
    private int count; // number of components
    public int numberOfConnectionGenerated = 0;

    ErdosRenyiUF(int[] a) {
        count = a.length;
        id = a;
        sz = new int[a.length];
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        // Make smaller root point to larger one.
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public static void main(String[] args) {
        int[] a = generateRandomPairsArray(20);
        ErdosRenyiUF wQU = new ErdosRenyiUF(a);
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++) {
                if(i != j) {
                    if (wQU.connected(a[i], a[j])){
                        wQU.union(a[i], a[j]);
                        StdOut.println(a[i] + " - " + a[j]);
                        wQU.numberOfConnectionGenerated++;
                    }
                }
            }
        }
        StdOut.println("Number of connection gererated: " + wQU.numberOfConnectionGenerated + " .");

    }

    private static int[] generateRandomPairsArray(int n){
        int[] a = new int[n];
        for(int i = 0; i < a.length; i++) {
            int uniform = StdRandom.uniform(0, 20);
            a[i] = uniform;
        }
        return a;
    }
}
