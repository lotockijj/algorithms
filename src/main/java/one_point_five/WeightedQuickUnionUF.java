package one_point_five;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WeightedQuickUnionUF {
    private int[] id; // access to component id (site indexed)
    private int[] sz; // size of component for roots (site indexed)
    private int count; // number of components
    public int numberOfAccess = 0;

    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    private int find(int p) { // Follow links to find a root.
        while (p != id[p]) {
            p = id[p];
            numberOfAccess++;
        }
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        // Make smaller root point to larger one.
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
            numberOfAccess++;
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
            numberOfAccess++;
        }
        count--;
    }

    // See page 222 (quick-find),page 224 (quick-union) andpage 228 (weighted).
    public static void main(String[] args) throws FileNotFoundException { // Solve dynamic connectivity problem on StdIn.
        File file = new File("C:\\Users\\Роман\\Downloads\\alglorithms\\src\\main\\resources\\tinyUF2.txt");
        Scanner sc=new Scanner(file);
        int N = sc.nextInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N); // Initialize N components.
        while (sc.hasNext()) {
            int p = sc.nextInt();
            int q = sc.nextInt(); // Read pair to connect.
            if (uf.connected(p, q)) continue; // Ignore if connected.
            uf.union(p, q); // Combine components
            StdOut.println(p + " " + q); // and print connection.
        }
        StdOut.println(uf.count() + " components");
        if(sc != null){
            sc.close();
        }
        StdOut.println("Number of access id: " + uf.numberOfAccess);
    }
}

