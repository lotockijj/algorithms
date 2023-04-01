package one_point_five;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UF2 {
    private int[] id; // access to component id (site indexed)
    private int count; // number of components
    public int numberOfAccess;

    public UF2(int N) { // Initialize component id array.
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
        numberOfAccess = 0;
    }
    public int count() {
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int find(int p) {
        numberOfAccess++;
        return id[p];
    }

    public void union(int p, int q) { // Put p and q into the same component.
        int pID = find(p);
        int qID = find(q);
        // Nothing to do if p and q are already in the same component.
        if (pID == qID) return;
        // Rename p’s component to q’s name.
        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) {
                numberOfAccess++;
                id[i] = qID;
            }
        count--;
    }

    private int findQuickUnion(int p) { // Find component name.
        while (p != id[p]){
            p = id[p];
            numberOfAccess++;
        }
        return p;
    }
    public void unionQuickUnion(int p, int q) { // Give p and q the same root.
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
        numberOfAccess++;
    }

    // See page 222 (quick-find),page 224 (quick-union) andpage 228 (weighted).
    public static void main(String[] args) throws FileNotFoundException { // Solve dynamic connectivity problem on StdIn.
        File file = new File("C:\\Users\\Роман\\Downloads\\alglorithms\\src\\main\\resources\\tinyUF2.txt");
        Scanner sc=new Scanner(file);
        int N = sc.nextInt();
        UF2 uf = new UF2(N); // Initialize N components.
        while (sc.hasNext()) {
            int p = sc.nextInt();
            int q = sc.nextInt(); // Read pair to connect.
            if (uf.connected(p, q)) continue; // Ignore if connected.
            uf.unionQuickUnion(p, q); // Combine components
            StdOut.println(p + " " + q); // and print connection.
        }
        StdOut.println(uf.count() + " components");
        if(sc != null){
            sc.close();
        }
        StdOut.println("Number of access id: " + uf.numberOfAccess);
    }
}
