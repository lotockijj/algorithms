package one_point_five;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UF_Quick_union {
    private int[] id; // access to component id (site indexed)
    private int count; // number of components

    public UF_Quick_union(int N) { // Initialize component id array.
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    private int find(int p) { // Find component name.
        while (p != id[p]) p = id[p];
        return p;
    }
    public void union(int p, int q) { // Give p and q the same root.
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    // See page 222 (quick-find),page 224 (quick-union) andpage 228 (weighted).
    public static void main(String[] args) throws FileNotFoundException { // Solve dynamic connectivity problem on StdIn.
        File file = new File("C:\\Users\\Роман\\Downloads\\alglorithms\\src\\main\\resources\\tinyUF.txt");
        Scanner sc=new Scanner(file);
        int N = sc.nextInt();
        UF uf = new UF(N); // Initialize N components.
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
    }
}