package four.one;

/*
Show, in the style of the figure on page 545, a detailed trace of CC for finding the connected components
in the graph built by Graph’s input stream constructor for the file tinyGex2.txt (see Exercise 4.1.2).
 */

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_4_1_19 {

    public static void main(String[] args) {
        Graph G = new Graph(new In("tinyGex2.txt"));
        CC cc = new CC(G);
        int M = cc.count();
        StdOut.println(M + " components");
        Bag<Integer>[] components;
        components = (Bag<Integer>[]) new Bag[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Bag<>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].add(v);
        }
        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
    }
}
